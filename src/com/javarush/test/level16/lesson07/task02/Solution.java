package com.javarush.test.level16.lesson07.task02;

/* Stopwatch (Секундомер)
1. Разберись, что делает программа.
2. Реализуй логику метода doSeveralSteps так, чтобы учитывалась скорость бегуна.
2.1. Метод getSpeed() в классе Runner показывает, сколько шагов в секунду делает бегун.
Нужно, чтобы бегун действительно делал заданное количество шагов в секунду.
Если Иванов делает 4 шага в секунду, то за 2 секунды он сделает 8 шагов.
Если Петров делает 2 шага в секунду, то за 2 секунды он сделает 4 шага.
2.2. Метод sleep в классе Thread принимает параметр типа long.
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private static volatile boolean isStopped = false;

  public static void main(String[] args) throws InterruptedException {
    Runner ivanov = new Runner("Ivanov", 4);
    Runner petrov = new Runner("Petrov", 2);
    //на старт!
    //внимание!
    //марш!
    ivanov.start();
    petrov.start();
    TimeUnit.SECONDS.sleep(2);
    isStopped = true;
    TimeUnit.SECONDS.sleep(1);
  }

  static class Stopwatch extends Thread {

    private final Runner owner;
    private int stepNumber;

    Stopwatch(Runner runner) {
      this.owner = runner;
    }

    public void run() {
      try {
        while (!isStopped) {
          doSeveralSteps();
        }
      } catch (InterruptedException ignored) {
      }
    }

    private void doSeveralSteps() throws InterruptedException {
      stepNumber++;
      TimeUnit.MILLISECONDS.sleep((long) (1000 / owner.getSpeed()));
      System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
    }
  }

  static class Runner {

    final Stopwatch stopwatch;
    private final String name;
    private final double speed;

    Runner(String name, double speed) {
      this.name = name;
      this.speed = speed;
      this.stopwatch = new Stopwatch(this);
    }

    String getName() {
      return name;
    }

    double getSpeed() {
      return speed;
    }

    void start() {
      stopwatch.start();
    }
  }
}
