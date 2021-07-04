
package com.example.nio.http;

import java.io.IOException;

/**
 * 发起HTTP请求的类
 */
public class HttpClient {

    /** 请求地址 */
    private static final String URL = "http://localhost:8801";

    public static void main(String[] args) throws IOException {
        String result = HttpUtils.getUrl(URL);
        System.out.println("返回结果:" + result);

    }
}
