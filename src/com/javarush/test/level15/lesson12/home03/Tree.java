package com.javarush.test.level15.lesson12.home03;

class Tree {

  private static int globalNumber;
  private final int number;

  Tree() {
    this.number = ++globalNumber;
  }

  public void info(Object s) {
    System.out.println(String
        .format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
  }

  public void info(Number s) {
    System.out.println(String
        .format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName()));
  }

  public void info(String s) {
    System.out.println(String
        .format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName()));
  }
}
