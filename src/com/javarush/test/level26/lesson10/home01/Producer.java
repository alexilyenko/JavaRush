package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

  private final BlockingQueue<String> queue;

  Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  public void run() {
    try {
      int i = 0;
      //noinspection InfiniteLoopStatement
      while (true) {
        queue.put(String.valueOf(i++));
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out
          .println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
    }
  }
}