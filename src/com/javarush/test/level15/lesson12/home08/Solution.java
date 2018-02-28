package com.javarush.test.level15.lesson12.home08;

/* Дебаг, дебаг, и еще раз дебаг
Программа выводит 0 9, а должна 6 9. Найди одну! ошибку и исправь.
Используй дебаг. Для этого поставь breakpoint-ы(Ctrl+F8), потом зайди в меню Run -> Debug.
F9 - выполнение кода до следующего breakpoint-а
F8 - переход к следующей строке кода
*/

class Solution {

  public static void main(String[] args) {
    new B(6);
  }

  static class A {

    private final int f1;

    A(int f1) {
      this.f1 = f1;
      initialize();
    }

    private void initialize() {
      System.out.println(f1);
    }
  }

  static class B extends A {

    int f1;

    B(int f1) {
      super(f1);
      this.f1 += f1;
      initialize();
    }

    void initialize() {
      System.out.println(f1);
    }
  }
}
