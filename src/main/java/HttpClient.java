import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.StringUtil;

public class HttpClient {

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = 8888;
    static final String URL = System.getProperty("url", "/testH2");

    public static void main(String[] args) throws InterruptedException {

        String sport = System.getenv("GLAHA_CHUNK_PORT");
        String shost = System.getenv("GLAHA_CHUNK_HOST");
        String surl = System.getenv("GLAHA_CHUNK_URL");

        int port = StringUtil.isNullOrEmpty(sport)?PORT:Integer.valueOf(sport);
        String host = StringUtil.isNullOrEmpty(shost)?HOST:shost;
        String url = StringUtil.isNullOrEmpty(surl)?URL:surl;


        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new HttpClientChannelInitializer());
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
