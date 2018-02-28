package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ailenko on 08.05.2014.
 */
class Producer implements Runnable {

  @SuppressWarnings("FieldCanBeLocal")
  private final ConcurrentHashMap<String, String> map;

  Producer(ConcurrentHashMap<String, String> map) {
    this.map = map;
  }

  public void run() {
    try {
      int i = 1;
      //noinspection InfiniteLoopStatement
      while (true) {
        System.out.println("Some text for " + i++);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out
          .println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
    }
  }

}
