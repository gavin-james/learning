package com.gavin.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
  public static void main(String[] args) {
    // 举例说明 Buffer 的使用（简单说明）
    // 创建一个 Buffer allocate 说明存放的容量大小
    IntBuffer in = IntBuffer.allocate(5);

    in.put(5);
    in.put(51);
    in.put(145);
    in.put(514);
    in.put(524);

    in.flip();

    while (in.hasRemaining()) {
      System.out.println(in.get());
    }
  }
}
