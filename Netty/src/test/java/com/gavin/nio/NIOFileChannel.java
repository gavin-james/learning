package com.gavin.nio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOFileChannel {

  @Test
  public void testFileOutputStream() throws Exception {
    String str = "Hello Nio";

    // 创建一个输入流 -》 channel
    FileOutputStream fos = new FileOutputStream("file.txt");

    // 通过 FileOutputStream 获取对应的 Channel
    // 真实类型是fileChannelImpl
    FileChannel fileChannel = fos.getChannel();

    // 创建一个缓冲区 byteBuffer 
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 将数据放进 ByteBuffer
    buffer.put(str.getBytes(StandardCharsets.UTF_8));

    // 反转
    buffer.flip();

    // 将数据写入文件
    fileChannel.write(buffer);

    // 关闭流
    fos.close();
  }

  @Test
  public void testFileInputStream() throws Exception {

    File file = new File("file.txt");
    // 创建一个输入流 -》 channel
    FileInputStream fis = new FileInputStream(file);

    // 通过 FileOutputStream 获取对应的 Channel
    // 真实类型是fileChannelImpl
    FileChannel fileChannel = fis.getChannel();

    // 创建一个缓冲区 byteBuffer
    ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

    // 将数据写入文件
    fileChannel.read(buffer);

    System.out.println(new String(buffer.array()));
    // 关闭流
    fis.close();
  }

  @Test
  public void testCopyFile() throws Exception {
    // 创建一个输入流 -》 channel
    FileInputStream fis = new FileInputStream("file.txt");
    FileOutputStream fos = new FileOutputStream("copy.txt");

    // 通过 FileOutputStream 获取对应的 Channel
    // 真实类型是fileChannelImpl
    FileChannel fileChannel = fis.getChannel();
    FileChannel fosChannel = fos.getChannel();

    // 创建一个缓冲区 byteBuffer
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 将数据写入 byteBuffer
    while (true) {
      buffer.clear();
      int read = fileChannel.read(buffer);
      if (read == -1) {
        break;
      }
      buffer.flip();
      fosChannel.write(buffer);
    }

    // 关闭流
    fos.close();
    fis.close();
  }

  @Test
  public void testTransform() throws Exception {
    // 创建一个输入流 -》 channel
    FileInputStream fis = new FileInputStream("file.txt");
    FileOutputStream fos = new FileOutputStream("transform.txt");

    // 通过 FileOutputStream 获取对应的 Channel
    // 真实类型是fileChannelImpl
    FileChannel fileChannel = fis.getChannel();
    FileChannel fosChannel = fos.getChannel();

    // 创建一个缓冲区 byteBuffer
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    fosChannel.transferFrom(fileChannel, 0, fileChannel.size());

    // 关闭流
    fosChannel.close();
    fileChannel.close();
    fos.close();
    fis.close();
  }
}
