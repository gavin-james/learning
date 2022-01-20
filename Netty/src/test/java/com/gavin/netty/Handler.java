package com.gavin.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class Handler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("server ctx = " + ctx);
    ByteBuf byteBuf = (ByteBuf) msg;
    System.out.println("获取到的信息是-》" + ((ByteBuf) msg).toString(StandardCharsets.UTF_8));
    System.out.println("客户端的地址是 : " + ctx.channel().remoteAddress());
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", StandardCharsets.UTF_8));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
