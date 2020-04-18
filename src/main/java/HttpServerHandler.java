import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;

import java.nio.charset.Charset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HttpServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server aggregator" + msg.toString());
        super.channelRead(ctx, msg);
    }

    //    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        if (msg instanceof HttpRequest) {
//            HttpRequest request = (HttpRequest) msg;
//            System.out.println(request.uri());
//            System.out.println(request.headers().toString());
//            if (HttpUtil.is100ContinueExpected(request)) {
//                System.out.println("request has expect headers");
//            }
//        }
//
//        if (msg instanceof HttpContent) {
//            HttpContent content = (HttpContent) msg;
//            System.out.println("seq:" + ++counter);
//            System.out.println(content.content().toString(Charset.defaultCharset()));
//        }
//    }
}
