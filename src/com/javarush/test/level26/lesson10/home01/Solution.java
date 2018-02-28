package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Мир скучен для скучных людей.
Разберитесь с BlockingQueue
По образу и подобию класса Producer создайте класс Consumer, который будет выводить данные из BlockingQueue в консоль
*/

class Solution {

  public static void main(String[] args) throws Exception {

    BlockingQueue queue = new ArrayBlockingQueue(32);

    @SuppressWarnings("unchecked") Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.submit(producer);
    executorService.submit(consumer);

    Thread.sleep(2000);

    executorService.shutdownNow();

  }
}

