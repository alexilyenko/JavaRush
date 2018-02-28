package com.javarush.test.level20.lesson10.home08;

/* Правильный вывод
Расставить обращение к методам суперкласса и модификаторы доступа так, чтобы вывод на экран был следующим:

C class, method2
A class, method2
A class, method1
B class, method1
*/
public class Solution {

  public static void main(String[] s) {
    A a = new C();
    a.method2();
  }

  static class A {

    private void method1() {
      System.out.println("A class, method1");
    }

    void method2() {
      System.out.println("A class, method2");
      method1();
    }
  }

  static class B extends A {

    void method1() {
      super.method2();
      System.out.println("B class, method1");
    }

    public void method2() {
      System.out.println("B class, method2");
    }
  }

  public static class C extends B {

    public void method1() {
      System.out.println("C class, method1");
    }

    public void method2() {
      System.out.println("C class, method2");
      super.method1();
    }
  }
}
