package com.javarush.test.level22.lesson05.home01;

class Task implements Runnable {

  private final String initialString;
  private final Solution solution;

  Task(Solution solution, String initialString) {
    this.solution = solution;
    this.initialString = initialString;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    String str = this.initialString;
    //noinspection ConstantConditions
    do {
      System.out.println(name + str);
    } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
  }
}
