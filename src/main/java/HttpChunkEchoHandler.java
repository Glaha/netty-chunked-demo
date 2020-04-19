import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

public class HttpChunkEchoHandler extends ChannelInboundHandlerAdapter {

    private int time = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("request time:" + ++time + msg.toString());
        if (msg instanceof HttpRequest) {
            System.out.println(((HttpRequest) msg).headers().toString());
        }
        super.channelRead(ctx, msg);
    }
}
