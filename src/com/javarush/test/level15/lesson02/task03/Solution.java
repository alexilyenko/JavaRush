package com.javarush.test.level15.lesson02.task03;

/* ООП - машинки
1. Для вывода использовать можно только переменные из класс Constants.
2. В классе Ferrari реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на Феррари".
3. В классе Lanos реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на Ланосе".
4. Создайте public static класс LuxuriousCar(РоскошнаяМашина).
5. Создайте public static класс CheapCar(ДешеваяМашина).
6. Унаследуйте Ferrari и Lanos от CheapCar и LuxuriousCar, подумайте, какой класс для кого.
7. В классе LuxuriousCar реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на роскошной машине".
8. В классе CheapCar реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на дешевой машине".
9. В класах LuxuriousCar и CheapCar для метода printlnDesire расставьте различными способами модификаторы доступа так,
чтобы в классах Ferrari и Lanos выполнялось расширение видимости.
*/

class Solution {

  public static void main(String[] args) {
    new Solution.LuxuriousCar().printlnDesire();
    new Solution.CheapCar().printlnDesire();
    new Solution.Ferrari().printlnDesire();
    new Solution.Lanos().printlnDesire();
  }

  static class Ferrari extends LuxuriousCar {

    void printlnDesire() {
      System.out.println(Constants.WANT_STRING + Constants.FERRARY_NAME);
    }
  }

  static class Lanos extends CheapCar {

    void printlnDesire() {
      System.out.println(Constants.WANT_STRING + Constants.LANOS_NAME);
    }
  }

  static class LuxuriousCar {

    void printlnDesire() {
      System.out.println(Constants.WANT_STRING + Constants.LUXURIOUS_CAR);
    }
  }

  static class CheapCar {

    void printlnDesire() {
      System.out.println(Constants.WANT_STRING + Constants.CHEAP_CAR);
    }
  }

  static class Constants {

    static final String WANT_STRING = "Я хочу ездить на ";
    static final String LUXURIOUS_CAR = "роскошной машине";
    static final String CHEAP_CAR = "дешевой машине";
    static final String FERRARY_NAME = "Феррари";
    static final String LANOS_NAME = "Ланосе";
  }
}
