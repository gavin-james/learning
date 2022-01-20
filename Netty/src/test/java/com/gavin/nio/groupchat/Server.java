package com.gavin.nio.groupchat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Server {
  private Selector selector;
  private ServerSocketChannel serverSocketChannel;
  private static final int port = 6667;

  @BeforeAll
  void beforeAll() throws Exception {
    selector = Selector.open();
    serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(port));
    serverSocketChannel.configureBlocking(false);
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
  }

  public void listen() {
    try {
      while (true) {
        int count = selector.select();
        if (count > 0) {
          Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

          while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            if (key.isAcceptable()) {
              SocketChannel accept = serverSocketChannel.accept();
              accept.configureBlocking(false);
              accept.register(selector, SelectionKey.OP_READ);
              System.out.println(accept.getRemoteAddress() + "-----上线");
            }
            if (key.isReadable()) {
              readData(key);
            }
            if (key.isWritable()) {

            }
            iterator.remove();
          }

        } else {
          System.out.println("等待中-------");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

    }
  }


  void readData(SelectionKey key) {
    SocketChannel socketChannel = null;
    try {
      socketChannel = (SocketChannel) key.channel();
      ByteBuffer byteBuffer = (ByteBuffer) key.attachment();

      int read = socketChannel.read(byteBuffer);
      if (read > 0) {
        String msg = new String(byteBuffer.array());
        System.out.println("from 客户端：" + msg);

        sendInfoToOtherClient(msg, socketChannel);
      }
    } catch (Exception e) {
      try {
        System.out.println(socketChannel.getRemoteAddress() + "离线了");
        key.cancel();
        socketChannel.close();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
      e.printStackTrace();
    } finally {

    }
  }

  void sendInfoToOtherClient(String msg, SocketChannel self) {
    System.out.println("服务器转发消息中-----");
    for (SelectionKey key : selector.keys()) {
      Channel channel = key.channel();

      if (channel instanceof SocketChannel && channel != self) {
        SocketChannel channel1 = (SocketChannel) channel;

        ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
        try {
          channel1.write(wrap);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  void testServer() {
    listen();
  }
}
