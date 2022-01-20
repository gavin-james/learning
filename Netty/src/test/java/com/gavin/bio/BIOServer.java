package com.gavin.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Gavin
 */
public class BIOServer {
  /**
   * 日志输出
   */
  private static final Logger log = Logger.getGlobal();

  public static void main(String[] args) throws Exception {

    // 线程池机制
    // 思路
    // 1 创建线程池
    // 2 如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）
    ExecutorService executorService = Executors.newCachedThreadPool();

    // 创建serverSocket
    ServerSocket socket = new ServerSocket(6666);

    while (true) {
      Socket accept = socket.accept();
      log.info("连接一个Socket");
      executorService.execute(() -> {
        // 处理接收到的请求
        try {
          handler(accept);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
  }

  private static void handler(Socket accept) throws Exception {
    byte[] bytes = new byte[1024];
    InputStream inputStream = accept.getInputStream();
    while (true) {
      int read = inputStream.read(bytes);

      if (read != -1) {
        log.info(new String(bytes, 0, read));
      } else {
        break;
      }
    }
    accept.close();
  }
}
