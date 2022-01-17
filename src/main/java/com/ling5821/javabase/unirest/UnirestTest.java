package com.ling5821.javabase.unirest;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 * @author linG
 * @date 2021-12-15 1:06
 */
public class UnirestTest {

    public static void main(String[] args) {
        String json = "{\"name\":\"hello\",\"age\":15,\"address\":\"zh\",\"hobbies\":[\"xxxx\",\"xxxxxxx\"]}";

        HttpResponse<String> response = Unirest.get("https://www.baidu.com")
            .queryString("json", json)
            .asString();
        System.out.println(response.getBody());
    }
}
