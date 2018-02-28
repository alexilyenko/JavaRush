package com.javarush.test.level26.lesson05.task01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Для того, чтобы усовершенствовать ум, надо больше размышлять, чем заучивать.
Расставьте volatile там, где необходимо
*/
class Solution extends Thread {

  private static final String DEFAULT_JAVARUSH_THREAD_NAME = "JavaRushThread";

  private static final AtomicInteger createdThreadIndex = new AtomicInteger();
  private static final AtomicInteger aliveThreadIndex = new AtomicInteger();
  private static final Logger log = Logger.getAnonymousLogger();

  private Solution(Runnable runnable) {
    this(runnable, DEFAULT_JAVARUSH_THREAD_NAME);
  }

  private Solution(Runnable runnable, String name) {
    super(runnable, name + "-" + createdThreadIndex.incrementAndGet());

    setUncaughtExceptionHandler(
        (t, e) -> log.log(Level.SEVERE, "An error occurred in thread " + t.getName(), e));
  }

  public static void main(String[] args) {
    new Solution(() -> System.out.println("test JavaRush Runnable for Solution class")).start();

    new Solution(() -> {
      throw new RuntimeException("Oops");
    }).start();
  }

  public void run() {
    try {
      aliveThreadIndex.incrementAndGet();
      super.run();
    } finally {
      aliveThreadIndex.decrementAndGet();
    }
  }
}
