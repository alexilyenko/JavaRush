package com.javarush.test.level15.lesson12.home10;

/* ООП - наследование
Исправить класс Hrivna так, чтоб избежать ошибку StackOverflowError, класс Money менять нельзя.
*/

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Hrivna().getAmount());
  }

  static abstract class Money {

    abstract Money getMoney();

    Object getAmount() {
      return getMoney().getAmount();
    }
  }

  //add your code below - добавь код ниже
  public static class Hrivna extends Money {

    final double amount = 123d;

    public Hrivna getMoney() {
      return this;
    }

    Object getAmount() {
      return amount;
    }
  }
}
