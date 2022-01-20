package com.gavin.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOClient {
  @Test
  void testClient() throws Exception {

    SocketChannel socketChannel = SocketChannel.open();

    socketChannel.configureBlocking(false);

    if (!socketChannel.connect(new InetSocketAddress(6666))) {

      while (!socketChannel.finishConnect()) {
        System.out.println("因为连接需要时间，客户端不会阻塞，可以作别的事情");
      }
    }

    String str = "hello Nio";
    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
    socketChannel.write(wrap);
    System.in.read();
  }
}
