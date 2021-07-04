
package com.example.nio.http;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * OKHttp 工具类
 */
public class HttpUtils {

    /**
     * Http请求 GET
     * @param url 请求路径
     * @return 返回对象
     */
    public static String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = Client.INSTANCE.getInstance().newCall(request).execute();
        return response.body().string();
    }


}
