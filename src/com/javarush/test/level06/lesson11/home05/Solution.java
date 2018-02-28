package com.javarush.test.level06.lesson11.home05;

/* Есть новые идеи? Подумаем...
1. В классе Solution создать public статический класс Idea
2. В классе Idea создать метод public String getDescription(), который будет возвращать любой непустой текст
3. В классе Solution создайте статический метод public void printIdea(Idea idea), который будет выводить
на экран описание идеи - это то, что возвращает метод getDescription
*/

class Solution {

  public static void main(String[] args) {
    Idea op = new Idea();
    printIdea(op);
  }

  private static void printIdea(Idea id) {
    System.out.println(id.getDescription());
  }

  static class Idea {

    @SuppressWarnings("SameReturnValue")
    String getDescription() {
      return "waaaat?";
    }
  }
}
