package com.ling5821.javabase.okhttp;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/**
 * @author linG
 * @date 2021-12-14 23:56
 */
public class OkHttpTest {

    public static void main(String[] args) throws IOException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();

        String json = "{\"name\":\"hello\",\"age\":15,\"address\":\"zh\",\"hobbies\":[\"xxxx\",\"xxxxxxx\"]}";
        HttpUrl base = HttpUrl.parse("https://www.baidu.com");
        if (base == null) {
            return;
        }
        HttpUrl.Builder urlBuilder = base.newBuilder();
        for (int i = 0; i < 10; i++) {
            urlBuilder.addQueryParameter("json" + i, json);
        }
        HttpUrl url = urlBuilder.build();
        Request request = new Builder().url(url).build();
        Response response = client.newCall(request).execute();
        System.out.println(response);

    }

}
