import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

public class HttpChunkEchoHandler extends ChannelInboundHandlerAdapter {

    private int time = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("request time:" + ++time + msg.toString());
        super.channelRead(ctx, msg);
    }
}
