package com.javarush.test.level26.lesson10.home02;

// TODO: uncomment - import com.javarush.test.level26.lesson10.home02.Producer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Мир не меняется, меняемся мы.
Разберитесь с ConcurrentHashMap
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды выводить на консоль с новой строки начиная с 1 фразу [Some text for i] , пример "Some text for 1"
2. при возникновении исключения выводить в консоль [[TREAD_NAME] thread was terminated], пример "[thread-1] thread was terminated"
*/


class Solution {

  public static void main(String[] args) throws Exception {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    Producer producer = new Producer(map);
    Consumer consumer = new Consumer(map);

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.submit(producer);
    executorService.submit(consumer);

    Thread.sleep(2000);

    executorService.shutdownNow();
    //finally 5 lines have to be printed
  }
}

