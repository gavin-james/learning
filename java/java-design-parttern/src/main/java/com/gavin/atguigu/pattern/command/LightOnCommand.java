package com.gavin.atguigu.pattern.command;

public class LightOnCommand implements Command{

  private LIghtReceiver lIghtReceiver;

  public LightOnCommand(LIghtReceiver lIghtReceiver) {
    this.lIghtReceiver = lIghtReceiver;
  }

  @Override
  public void execute() {
    lIghtReceiver.on();
  }

  @Override
  public void undo() {
    lIghtReceiver.off();
  }
}
