package com.gavin.atguigu.pattern.command;

public class Client {
  public static void main(String[] args) {
    RemoteController remoteController = new RemoteController();

    LIghtReceiver lIghtReceiver = new LIghtReceiver();

    LightoffCommand lightoffCommand = new LightoffCommand(lIghtReceiver);
    LightOnCommand lightOnCommand = new LightOnCommand(lIghtReceiver);

    remoteController.setCommand(1,lightOnCommand,lightoffCommand);

    remoteController.onButtonWasPushed(1);
    remoteController.undoButtonWasPushed(1);
    remoteController.offButtonWasPushed(1);
    remoteController.undoButtonWasPushed(1);

  }
}
