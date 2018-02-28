package com.javarush.test.level16.lesson13.bonus03;

/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)

Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/

class Solution {

  private static final Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

  public static void main(String[] args) {
    TestedThread commonThread = new TestedThread(handler);

    Thread threadA = new Thread(commonThread, "Нить 1");
    Thread threadB = new Thread(commonThread, "Нить 2");

    threadA.start();
    threadB.start();
    threadA.interrupt();
    threadB.interrupt();

  }

  static class TestedThread extends Thread {

    TestedThread(UncaughtExceptionHandler handler) {
      setDefaultUncaughtExceptionHandler(handler);
      start();
    }

    public void run() {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException x) {
        throw new RuntimeException("My exception message");
      }
    }
  }

  static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
      System.out.println(t.getName() + ": " + e.getMessage());
    }
  }
}
