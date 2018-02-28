package com.javarush.test.level12.lesson12.home09;

/* Родитель класса CTO
Добавь такой класс-родитель к классу CTO(технический директор), чтобы класс перестал быть абстрактным.
Добавлять/реализовывать методы в классе CTO запрещается.
*/

public class Solution {

  public static void main(String[] args) {
    CTO cto = new CTO();
    System.out.println(cto);
  }

  interface Businessman {

    void workHard();
  }

  public static class Director implements Businessman {

    public void workHard() {
      System.out.print("I'm working hard!");
    }
  }

  private static class CTO extends Director implements Businessman {

  }


}
