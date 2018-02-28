package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {

  static class A implements Cloneable {

    private final int i;
    private final int j;

    A(int i, int j) {
      this.i = i;
      this.j = j;
    }

    int getI() {
      return i;
    }

    int getJ() {
      return j;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      return super.clone();
    }

  }

  public static class B extends A {

    private final String name;

    B(int i, int j, String name) {
      super(i, j);
      this.name = name;
    }

    String getName() {
      return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException();
    }

  }

  public static class C extends B {

    C(int i, int j, String name) {
      super(i, j, name);
    }

    private C duplicate(C c) {
      return new C(c.getI(), c.getJ(), c.getName());
    }

    @Override
    public C clone() throws CloneNotSupportedException {
      C c = (C) super.clone();
      return duplicate(this);
    }
  }
}
