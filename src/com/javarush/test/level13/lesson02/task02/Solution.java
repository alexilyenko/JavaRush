package com.javarush.test.level13.lesson02.task02;

/* Пиво: возвращение
Добавь к классу Beer интерфейс Drink и реализуй все нереализованные методы.
*/

public class Solution {

  public static void main(String[] args) {
    Drink beer = new Beer();
    System.out.println(beer.toString());
  }

  interface Drink {

    @SuppressWarnings("SameReturnValue")
    boolean isAlcoholic();
  }

  public static class Beer implements Drink {

    @Override
    public String toString() {
      if (isAlcoholic()) {
        return "Напиток алкогольный";
      } else {
        return "Напиток безалкогольный";
      }
    }

    public boolean isAlcoholic() {
      return true;
    }
  }
}
