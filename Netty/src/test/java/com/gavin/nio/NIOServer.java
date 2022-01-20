package com.gavin.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

  @Test
  void testServer() throws Exception {
    // create ServerSocketChannel -> ServerSocket
    ServerSocketChannel open = ServerSocketChannel.open();

    // get Selector Object
    Selector selector = Selector.open();

    // binding port to 6666
    open.socket().bind(new InetSocketAddress(6666));
    // 设置为非阻塞
    open.configureBlocking(false);
    // 将其注册到 selector中 事件为 op_accept
    open.register(selector, SelectionKey.OP_ACCEPT);

    // 循环等待客户端连接
    while (true) {
      // 这里等待1秒钟，如果没有事件发生，返回
      if (selector.select(1000) == 0) {
        System.out.println("服务器等待了一秒，无连接");
        continue;
      }

      // 获取 selectionKeys 并遍历

      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()) {
        SelectionKey i = iterator.next();
        if (i.isAcceptable()) {
          try {
            // 生成一个 SocketChannel
            SocketChannel accept = open.accept();

            System.out.println("客户端产生了一个连接" + accept.hashCode());
            accept.configureBlocking(false);
            // 注册到selector中
            accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

          } catch (IOException e) {
            e.printStackTrace();
          }
        } else if (i.isReadable()) {
          SocketChannel channel = (SocketChannel) i.channel();
          ByteBuffer buffer = (ByteBuffer) i.attachment();
          try {
            channel.read(buffer);
            System.out.println("客户端获取的信息是：" + new String(buffer.array()));
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        iterator.remove();

      }

    }

  }
}
