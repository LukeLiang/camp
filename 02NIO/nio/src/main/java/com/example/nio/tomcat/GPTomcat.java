
package com.example.nio.tomcat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {

    private int port = 8080;
    private ServerSocket server;
    private Map<String, GPServlet> servletMapping = new HashMap<>();

    private Properties webXml = new Properties();

    private void init() {
        try {
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fls = new FileInputStream(WEB_INF + "web.properties");

            webXml.load(fls);

            for (Object k : webXml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
