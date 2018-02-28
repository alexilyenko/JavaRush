package com.javarush.test.level12.lesson12.home01;

/* Метод getName в классе Cat
Переопредели метод getName в классе Cat так, чтобы программа выдавала на экран надпись
«Я - кот».
*/

class Solution {

  public static void main(String[] args) {
    Pet pet = new Cat();

    System.out.println(pet.getName());
  }

  static class Pet {

    String getName() {
      return "Я - пушистик";
    }
  }

  static class Cat extends Pet {

    public String getName() {
      return "Я - кот";
    }

  }
}
