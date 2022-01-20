package com.gavin.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
  public static void main(String[] args)  {
      EventLoopGroup bossGroup = new NioEventLoopGroup();
      NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    try{

      ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup, workerGroup);
      bootstrap.channel(NioServerSocketChannel.class)
              .option(ChannelOption.SO_BACKLOG, 128)
              .childOption(ChannelOption.SO_KEEPALIVE, true)
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline().addLast(new Handler());
                }
              });

      ChannelFuture cf = bootstrap.bind(6666).sync();
      cf.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }

  }
}
