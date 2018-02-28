package com.javarush.test.level24.lesson04.home01;


/* Рефакторинг
В классе Rectangle:
1. Измените методы getHeight и getWidth, чтобы они возвращали HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создайте локальные классы - реализации интерфейсов.
3. Переименуйте getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажмите Shift+F6).
4. Уберите наследование интерфейсов в классе  Rectangle.
Методы интерфейсов не менять.
*/
class Solution {

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(1, 2, 3, 4);
//        System.out.println(getHeight(rectangle));
//        System.out.println(getWidth(rectangle));
    System.out.println(getHeight(rectangle.castToHasHeight()));
    System.out.println(getWidth(rectangle.castToHasWidth()));
  }

  private static double getHeight(HasHeight rectangle) {
    return rectangle.getHeight();
  }

  private static double getWidth(HasWidth rectangle) {
    return rectangle.getWidth();
  }


  static class Rectangle {

    private final Point point1;
    private final Point point2;

    Rectangle(double x1, double y1, double x2, double y2) {
      point1 = new Point(x1, y1);
      point2 = new Point(x2, y2);
    }

    HasHeight castToHasHeight() {
      return () -> Math.abs(point1.getY() - point2.getY());
    }

    HasWidth castToHasWidth() {
      return () -> Math.abs(point1.getX() - point2.getX());
    }
  }
}
