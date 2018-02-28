package com.javarush.test.level16.lesson03.task05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/* Поговорим о музыке?
1. Измените класс Violin так, чтоб он стал таском для нити. Используйте интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах. Пример "Playing 1002 ms".
*/

public class Solution {

  private static final int delay = 1000;

  public static void main(String[] args) {
    Thread violin = new Thread(new Violin("Player"));
    violin.start();
  }

  private static void sleepNSeconds(int n) {
    try {
      TimeUnit.MILLISECONDS.sleep(n * delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  interface MusicalInstrument extends Runnable {

    Date startPlaying();

    Date stopPlaying();
  }

  public static class Violin implements MusicalInstrument {

    private final String owner;

    Violin(String owner) {
      this.owner = owner;
    }

    public Date startPlaying() {
      System.out.println(this.owner + " starts playing");
      return new Date();
    }

    public Date stopPlaying() {
      System.out.println(this.owner + " stops playing");
      return new Date();
    }

    public void run() {
      long startDate = startPlaying().getTime();
      sleepNSeconds(1);
      long stopDate = stopPlaying().getTime();
      long time = stopDate - startDate;
      System.out.println("Playing " + time + " ms");
    }
  }
}
