
package com.example.nio.tomcat;

public class SecondServlet extends GPServlet {

    @Override
    protected void doPost(GPRequest request, GPResponse response) throws Exception {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(GPRequest request, GPResponse response) throws Exception {
        response.write("this is second servlet");
    }
}
