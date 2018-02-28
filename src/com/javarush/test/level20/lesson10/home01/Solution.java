package com.javarush.test.level20.lesson10.home01;

import java.io.Serializable;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
class Solution {

  class A implements Serializable {

    String name;

    A(String name) {
      this.name += name;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  class B extends A {

    String name;

    B(String name) {
      super(name);
      this.name += name;
    }
  }

  class C extends B {

    final String name;

    public C(String name) {
      super(name);
      this.name = name;
    }
  }
}
