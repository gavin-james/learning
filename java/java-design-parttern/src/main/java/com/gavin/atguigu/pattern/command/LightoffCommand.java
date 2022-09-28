package com.gavin.atguigu.pattern.command;

public class LightoffCommand implements Command{
  private LIghtReceiver lIghtReceiver;

  public LightoffCommand(LIghtReceiver lIghtReceiver) {
    this.lIghtReceiver = lIghtReceiver;
  }

  @Override
  public void execute() {
    lIghtReceiver.off();
  }

  @Override
  public void undo() {
    lIghtReceiver.on();
  }
}
