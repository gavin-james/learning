package com.gavin.nio.groupchat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.omg.CORBA.TIMEOUT;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Client {

  private SocketChannel socketChannel;
  private static final String Host = "127.0.0.1";
  private static final int port = 6667;
  private Selector selector;
  private String username;

  @BeforeAll
  void beforeAll() throws Exception {
    selector = Selector.open();
    socketChannel = SocketChannel.open(new InetSocketAddress(Host, port));
    socketChannel.configureBlocking(false);
    socketChannel.register(selector, SelectionKey.OP_READ);
    username = socketChannel.getLocalAddress().toString().substring(1);
    System.out.println(username + "is ok....");
  }

  void sendInfo(String info) {
    info = username + " 说： " + info;
    try {
      socketChannel.write(ByteBuffer.wrap(info.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void readInfo() {
    try {
      int select = selector.select();
      if (select > 0) {
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

        while (iterator.hasNext()) {
          SelectionKey key = iterator.next();
          if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            channel.read(buffer);
            String msg = new String(buffer.array());
            System.out.println(msg);
          }

        }

      } else {
//        System.out.println("没有可用通道。。。。。。");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void testClient() {
    new Thread(() -> {
      while (true) {
        readInfo();
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }).start();


    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      sendInfo(s);
    }
  }
}
