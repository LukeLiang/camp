
package com.example.nio.http;

import okhttp3.OkHttpClient;

/**
 * 简单单例模式创建OKHttp
 */
public enum Client{
    INSTANCE;
    private OkHttpClient client;
    private Client(){
        client = new OkHttpClient();
    }
    public OkHttpClient getInstance() {
        return client;
    }
}

