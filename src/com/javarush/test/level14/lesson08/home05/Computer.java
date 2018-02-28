package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Алексей on 12.04.2014.
 */
class Computer {

  private final Keyboard keyboard;
  private final Monitor monitor;
  private final Mouse mouse;

  Computer() {
    this.keyboard = new Keyboard();
    this.monitor = new Monitor();
    this.mouse = new Mouse();
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public Monitor getMonitor() {
    return monitor;
  }

  public Mouse getMouse() {
    return mouse;
  }

}
