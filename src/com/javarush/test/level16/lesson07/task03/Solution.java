package com.javarush.test.level16.lesson07.task03;

/* Big Ben clock
1. Разберись, что делает программа.
2. Реализуй логику метода printTime так, чтобы каждую секунду выдавалось время начиная с установленного в конструкторе
Пример:
В г. Лондон сейчас 23:59:58!
В г. Лондон сейчас 23:59:59!
В г. Лондон сейчас полночь!
В г. Лондон сейчас 0:0:1!
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private static volatile boolean isStopped = false;

  public static void main(String[] args) throws InterruptedException {
    Clock clock = new Clock("Лондон", 23, 59, 57);
    TimeUnit.SECONDS.sleep(4);
    isStopped = true;
    TimeUnit.SECONDS.sleep(1);
  }

  static class Clock extends Thread {

    private final String cityName;
    private int hours;
    private int minutes;
    private int seconds;

    Clock(String cityName, int hours, int minutes, int seconds) {
      this.cityName = cityName;
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
      start();
    }

    public void run() {
      try {
        while (!isStopped) {
          printTime();
        }
      } catch (InterruptedException ignored) {
      }
    }

    private void printTime() throws InterruptedException {
      TimeUnit.SECONDS.sleep(1);
      seconds++;
      if (seconds == 60) {
        seconds = 0;
        minutes++;
        if (minutes == 60) {
          minutes = 0;
          hours++;
          if (hours == 24) {
            hours = 0;
          }
        }
      }

      if (hours == 0 && minutes == 0 && seconds == 0) {
        System.out.println(String.format("В г. %s сейчас полночь!", cityName));
      } else {
        System.out
            .println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
      }
    }
  }
}
