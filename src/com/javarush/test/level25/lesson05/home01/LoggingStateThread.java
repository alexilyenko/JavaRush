package com.javarush.test.level25.lesson05.home01;

/**
 * Created by ailenko on 06.05.2014.
 */
class LoggingStateThread extends Thread {

  private final Thread target;

  LoggingStateThread(Thread target) {
    this.target = target;
    setDaemon(true);

  }

  @Override
  public void run() {
    State state = this.target.getState();
    System.out.println(state);
    while (state != State.TERMINATED) {
      if (state != this.target.getState()) {
        state = this.target.getState();
        System.out.println(state);
      }
    }
  }
}