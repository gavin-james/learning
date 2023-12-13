package com.gavin.atguigu.pattern.command;

public class RemoteController {
  Command[] onCommands;
  Command[] offCommands;

  Command undoCommand;

  public RemoteController() {
    onCommands = new Command[5];
    offCommands = new Command[5];
    for (int i = 0; i < 5; i++) {
      offCommands[i] = new NoCommand();
      onCommands[i] = new NoCommand();
    }
  }

  public void setCommand(int no, Command onCommand, Command offCommand) {
    offCommands[no] = offCommand;
    onCommands[no] = onCommand;
  }

  public void onButtonWasPushed(int no) {
    onCommands[no].execute();
    undoCommand = onCommands[no];
  }

  public void offButtonWasPushed(int no) {
    offCommands[no].execute();
    undoCommand = offCommands[no];
  }

  public void undoButtonWasPushed(int no) {
    undoCommand.undo();
  }
}
