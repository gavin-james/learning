package com.gavin.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
  public static void main(String[] args) {
    NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(eventExecutors)
              .channel(NioSocketChannel.class)
              .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline().addLast(new NettyClientHandler());
                }
              });
      System.out.println("客户端 ok");

      ChannelFuture connect = bootstrap.connect("127.0.0.1", 6666);
      connect.channel().closeFuture().sync();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
      eventExecutors.shutdownGracefully();
    }
  }
}
