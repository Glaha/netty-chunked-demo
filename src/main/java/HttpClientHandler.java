import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.internal.StringUtil;

import java.io.File;

public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    private String message = "111111111111111111111111111111111" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            System.getProperty("line.separator") +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "=========================================================";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        String sport = System.getenv("GLAHA_CHUNK_PORT");
        String shost = System.getenv("GLAHA_CHUNK_HOST");
        String surl = System.getenv("GLAHA_CHUNK_URL");

        int port = StringUtil.isNullOrEmpty(sport)? HttpClient.PORT:Integer.valueOf(sport);
        String host = StringUtil.isNullOrEmpty(shost)?HttpClient.HOST:shost;
        String url = StringUtil.isNullOrEmpty(surl)?HttpClient.URL:surl;

        DefaultHttpRequest httpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                HttpMethod.POST, "http://" + host + ":" + port + url, Unpooled.wrappedBuffer(message.getBytes()));
        httpRequest.headers().set(HttpHeaderNames.HOST, host);
        httpRequest.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
        //httpRequest.headers().set(HttpHeaderNames.CONTENT_LENGTH, 0);
//        httpRequest.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
        ctx.channel().writeAndFlush(httpRequest);

       /* HttpHeaders httpHeaders = new DefaultHttpHeaders();
        httpHeaders.set(HttpHeaderNames.HOST, "localhost");
        httpHeaders.set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
        DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, "http://localhost:8888/",httpHeaders);

        HttpChunkedInput httpChunkWriter = new HttpChunkedInput(
                new ChunkedFile("/tmp/myfile.txt"));
        HttpChunkedInput httpChunkedInput = new HttpChunkedInput(new ChunkedFile(
                new File(ClassLoader.getSystemClassLoader().getResource("good.file").getPath())),new DefaultLastHttpContent());
        ctx.channel().write(defaultHttpRequest);
        ctx.channel().writeAndFlush(httpChunkedInput);*/
    }

    private ByteBuf getContentByteBuf() {
        byte[] bytes = message.getBytes();
        int length = message.length();
        ByteBuf buffer = null;
        for (int i = 0; i < 2; i++) {
            buffer = Unpooled.buffer(length);
            buffer.writeBytes(bytes);
        }
        return buffer;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
