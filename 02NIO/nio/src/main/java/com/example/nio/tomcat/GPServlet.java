
package com.example.nio.tomcat;

public abstract class GPServlet {

    public void service(GPRequest request, GPResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    protected abstract void doPost(GPRequest request, GPResponse response) throws Exception;

    protected abstract void doGet(GPRequest request, GPResponse response) throws Exception;
}
