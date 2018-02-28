package com.javarush.test.level26.lesson05.task02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Трудолюбие - душа всякого дела и залог благосостояния.
Расставьте volatile там, где необходимо
*/
class Solution {

  private static ScheduledExecutorService interruptScheduledExecutor;
  private static Thread taskThread;

  public static void main(String[] args) throws Exception {
    runTaskBySchedule(() -> {
      System.out.println("A");
      throw new RuntimeException("it's test");
        }, 1_000, TimeUnit.MILLISECONDS
    );

    interruptScheduledExecutor.shutdown();
  }

  private static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit)
      throws Exception {
    RethrowableTask task = new RethrowableTask(runnable);
    taskThread = new Thread(task);
    taskThread.start();

    interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
    interruptScheduledExecutor.schedule(() -> taskThread.interrupt(), timeout, unit);
    taskThread.join(unit.toMillis(timeout));
    try {
      task.rethrow();
    } catch (Throwable throwable) {
      System.out.println(throwable.getMessage());
    }
  }

  static class RethrowableTask implements Runnable {

    private final Runnable runnable;
    private volatile Throwable throwable;

    RethrowableTask(Runnable runnable) {
      this.runnable = runnable;
    }

    public void run() {
      try {
        runnable.run();
      } catch (Throwable throwable) {
        this.throwable = throwable;
      }
    }

    void rethrow() throws Exception {
      if (throwable != null) {
        System.out.println("B");
        throw new Exception(throwable);
      }
    }
  }
}
