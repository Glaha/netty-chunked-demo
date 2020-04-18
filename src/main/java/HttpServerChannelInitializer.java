import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpRequestDecoder());
        ch.pipeline().addLast(new HttpChunkEchoHandler());
        ch.pipeline().addLast(new HttpObjectAggregator(Integer.MAX_VALUE));
        ch.pipeline().addLast(new HttpResponseEncoder());
        ch.pipeline().addLast(new ChunkedWriteHandler());
        ch.pipeline().addLast(new HttpServerHandler());
    }
}
