
package com.example.nio.gateway.inbound;

import com.example.nio.gateway.filter.HeaderHttpRequestFilter;
import com.example.nio.gateway.filter.HttpRequestFilter;
import com.example.nio.gateway.outbound.httpclient.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * Http请求处理类
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private List<String> servers;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public HttpInboundHandler(List<String> servers) {
        this.servers = servers;
        this.handler = new HttpOutboundHandler(this.servers);
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx, filter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
