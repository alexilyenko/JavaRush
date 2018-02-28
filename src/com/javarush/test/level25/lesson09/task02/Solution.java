package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
class Solution extends TimerTask {

  private final Thread.UncaughtExceptionHandler handler;
  private TimerTask original;

  public Solution(TimerTask original) {
    if (original == null) {
      throw new NullPointerException();
    }
    this.original = original;
    this.handler = (t, e) -> {
      @SuppressWarnings("ReplaceAllDot") String stars = t.getName().replaceAll(".", "*");
      String newMessage = e.getMessage().replace(t.getName(), stars);
      e = new Exception(newMessage, e);
      System.out.println(e.getMessage());
      t.setName(stars);
    };
  }

  public void run() {
    try {
      original.run();
    } catch (Throwable cause) {
      Thread currentThread = Thread.currentThread();
      handler.uncaughtException(currentThread,
          new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
    }
  }

  public long scheduledExecutionTime() {
    return original.scheduledExecutionTime();
  }

  public boolean cancel() {
    return original.cancel();
  }

}