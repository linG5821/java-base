package com.ling5821.javabase.sign;

/**
 * @author linG
 * @date 2022-06-23 23:09
 */

import cn.hutool.core.util.StrUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SignDemo2 {

    public static final String HTTPHeaderAuthorization = "Authorization";
    public static final String HTTPHeaderContentMD5 = "Content-MD5";
    public static final String HTTPHeaderContentType = "Content-Type";
    public static final String HTTPHeaderDate = "Date";

    private static final String CanonicalHeaderPrefix = "x-powerlaw-";
    private static final String AuthorizationPrefix = "Powerlaw";
    private static final String ACCESS_KEY_ID = "ZNoTGZWtCP3VOUG5Qpf4rHFA";
    private static final String ACCESS_KEY_SECRET = "VX9++2j+8VtySJKK0l7fZxY9QiAGYR3to0usxI0PFO0=";
    private static final String ALGORITHM = "HmacSHA256";

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(
            "https://openapi-test.alpha.milvzn.com/api/v1/review/file_stream_pattern");
        MultipartEntityBuilder mt = MultipartEntityBuilder.create();
        File file = new File("C:/Users/linG/Desktop/hello.docx");
        mt.addBinaryBody("file", file);
        mt.addTextBody("fileName", "hello.docx");
        mt.addTextBody("contractType", "xxx");
        mt.addTextBody("pointList",
            "[{\"resultIdList\":[\"租赁物适租状态陈述保证缺失\"],\"reviewId\":\"LEASE_RIGHT_REVIEW\"}]",
            ContentType.APPLICATION_JSON);
        request.setEntity(mt.build());
        CloseableHttpResponse resp;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            request.getEntity().writeTo(bos);
            bos.flush();
            String contentMd5 = buildContentMd5(bos.toByteArray());
            Header contentType = request.getEntity().getContentType();
            request.addHeader(HTTPHeaderContentType, contentType.getValue());
            request.addHeader(HTTPHeaderContentMD5, contentMd5);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'",
                Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Calendar calendar = Calendar.getInstance();
            String time = sdf.format(calendar.getTime());
            request.addHeader(HTTPHeaderDate, time);
            String sign = getSignedStr(request);
            request.addHeader(HTTPHeaderAuthorization,
                String.format("%s %s:%s", AuthorizationPrefix, ACCESS_KEY_ID
                    , sign));
            resp = client.execute(request);
            HttpEntity respEntity = resp.getEntity();
            System.out.println("status: " + resp.getStatusLine());
            if (respEntity != null) {
                System.out.println("content: " + EntityUtils.toString(respEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSignedStr(HttpRequestBase request) throws Exception {
        String method = request.getMethod();
        String contentMd5 = request.getFirstHeader(HTTPHeaderContentMD5).getValue();
        String contentType = request.getFirstHeader(HTTPHeaderContentType).getValue();
        String date = request.getFirstHeader(HTTPHeaderDate).getValue();
        String urlStr = buildURLStr(request);
        String canonicalStr = buildCanonicalHeaderStr(request);
        String signStr = String.format("%s\n%s\n%s\n%s\n%s\n%s\n",
            method, urlStr, contentMd5, contentType, date, canonicalStr);
        return genSignWithSha256(signStr, ACCESS_KEY_SECRET);
    }

    public static String genSignWithSha256(String str, String secret) throws
        NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256 = Mac.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
            ALGORITHM);
        sha256.init(secretKeySpec);
        byte[] signBytes = sha256.doFinal(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(Base64.getEncoder().encodeToString(signBytes));
        return Base64.getEncoder().encodeToString(signBytes);
    }

    public static String buildURLStr(HttpRequestBase request) throws Exception {
        URI uri = request.getURI();
        String path = uri.getRawPath();
        String query = uri.getRawQuery();
        if (StrUtil.isBlank(query)) {
            return path;
        }
        String[] arr = query.split("&");
        TreeMap<String, String> queryMap = new TreeMap<>();
        for (String str : arr) {
            String[] subArr = str.split("=");
            if (subArr.length != 2) {
                throw new Exception();
            }
            queryMap.put(subArr[0], subArr[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : queryMap.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            sb.append(key).append("=").append(val).append("&");
        }
        if (sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return String.format("%s?%s", path, sb);
    }

    public static String buildCanonicalHeaderStr(HttpRequestBase request) {
        Header[] headers = request.getAllHeaders();
        TreeMap<String, String> canonicalHeaderMap = new TreeMap<>();

        for (Header header : headers) {
            String headerName = header.getName().toLowerCase();
            if (StrUtil.startWith(headerName, CanonicalHeaderPrefix)) {
                canonicalHeaderMap.put(headerName, header.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : canonicalHeaderMap.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            sb.append(key).append(":").append(val);
        }
        return sb.toString();
    }

    public static String buildContentMd5(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(bytes);
        return Base64.getEncoder().encodeToString(md5.digest());
    }
}
