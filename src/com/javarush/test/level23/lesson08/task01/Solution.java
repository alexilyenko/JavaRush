package com.javarush.test.level23.lesson08.task01;

/* Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. "sout"
Сделайте минимум изменений.
*/
class Solution {

  private final String name;

  private Solution(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    new Solution("main").sout();
  }

  private String getName() {
    return name;
  }

  private void sout() {
    new Solution("sout") {
      void printName() {
        System.out.println(getName());
      }
    }.printName();
  }
}
