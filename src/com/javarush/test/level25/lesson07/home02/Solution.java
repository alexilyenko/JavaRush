package com.javarush.test.level25.lesson07.home02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* Все не так легко, как кажется
1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable
2. Реализуйте логику метода cancel в классе SocketTask
3. Реализуйте логику метода cancel для локального класса внутри метода newTask в классе SocketTask
*/
class Solution extends ThreadPoolExecutor {

  public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
      BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
    if (callable instanceof CancellableTask) {
      return ((CancellableTask<T>) callable).newTask();
    } else {
      return super.newTaskFor(callable);
    }
  }
}