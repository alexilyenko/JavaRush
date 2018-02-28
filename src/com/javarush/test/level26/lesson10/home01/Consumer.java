package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ailenko on 08.05.2014.
 */
class Consumer implements Runnable {

  private final BlockingQueue queue;

  Consumer(BlockingQueue queue) {
    this.queue = queue;
  }

  @SuppressWarnings("InfiniteLoopStatement")
  public void run() {
    try {
      //noinspection InfiniteLoopStatement
      while (true) {
        System.out.println(queue.take());
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out
          .println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
    }
  }
}
