import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.multipart.HttpPostRequestEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpRequestEncoder());
        pipeline.addLast(new HttpResponseDecoder());
        pipeline.addLast(new HttpClientHandler());
    }
}
