package com.javarush.test.level24.lesson09.task01;

interface JustAnInterface {

  B B = new B();

  class B extends C {

    B() {
      System.out.print("B");
    }
  }
}

/* Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS
*/
class Solution extends C {

  private A a = new A() {
    { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
      value = "Y";
      if (super.getClass().getName().contains(".Solution$")) {
        System.out.print(value);
      }
    }
  };

  private Solution() {
    System.out.print("S");
  }

  public static void main(String[] args) {
    new Solution();
  }

  private class A {

    String value = "A";

    A() {
      System.out.print(value);
    }
  }
}

class C implements JustAnInterface {

  C() {
    System.out.print("C");
    B localB = B;
  }
}



