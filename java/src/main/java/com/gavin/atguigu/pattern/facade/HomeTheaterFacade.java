package com.gavin.atguigu.pattern.facade;

public class HomeTheaterFacade {
  // 定一个各个子系统对象
  private TheaterLight theaterLight;
  private Popcon popcon;
  private Stereo stereo;
  private Projector projector;
  private Screeen screeen;
  private DVDPlayer dvdPlayer;

  public static void main(String[] args) {

  }

  public HomeTheaterFacade() {
    this.theaterLight = TheaterLight.getInstance();
    this.popcon = Popcon.getInstance();
    this.stereo = Stereo.getInstance();
    this.projector = Projector.getInstance();
    this.screeen = Screeen.getInstance();
    this.dvdPlayer = DVDPlayer.getInstance();
  }

  public void ready() {
    popcon.on();
    popcon.pop();
    screeen.down();
    projector.on();
    screeen.on();
    dvdPlayer.on();
    theaterLight.dim();
  }

  public void play() {
    dvdPlayer.play();
  }

  public void pause() {
    dvdPlayer.pause();
  }

  public void end() {
    popcon.off();
    screeen.up();
    projector.off();
    screeen.off();
    dvdPlayer.off();
  }


}
