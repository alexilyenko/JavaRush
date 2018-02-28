package com.javarush.test.level14.lesson08.home04;

/* Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.
2. Метод main менять нельзя.
*/

public class Solution {

  public static void main(String[] args) {
    Object obj = new Circle();
    Movable movable = (Movable) obj;
    Drawable drawable = new Rectangle();

    printMainInfo(drawable);
    printMainInfo(movable);
  }

  private static void printMainInfo(Object object) {
    if (object instanceof Drawable) {
      ((Drawable) object).draw();
    } else if (object instanceof Movable) {
      ((Movable) object).move();
    }
  }

  interface Movable {

    void move();
  }

  interface Drawable {

    void draw();
  }

  static class Circle implements Movable {

    public void draw() {
      System.out.println("can be drawn");
    }

    public void move() {
      System.out.println("can be moved");
    }

  }

  static class Rectangle implements Drawable {

    public void draw() {
      System.out.println("can be drawn");
    }

    public void move() {
      System.out.println("can be moved");
    }
  }
}
