package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

class Solution {

  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);
    Stopwatch stopwatch = new Stopwatch();
    stopwatch.start();
    reader.readLine();
    stopwatch.interrupt();
    reader.close();
    in.close();
  }

  static class Stopwatch extends Thread {

    private int seconds;

    public void run() {
      try {
        while (!isInterrupted()) {
          Thread.sleep(1000);
          seconds++;
        }
      } catch (InterruptedException e) {
        System.out.println(seconds);
      }
    }
  }
}
