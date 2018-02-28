package com.javarush.test.level12.lesson12.home02;

/* Метод setName в классе Cat
Переопредели метод setName в классе Cat так, чтобы программа выдавала на экран надпись
«Я - кот».
*/

class Solution {

  public static void main(String[] args) {
    Pet pet = new Cat();
    pet.setName("Я - пушистик");

    System.out.println(pet.getName());
  }

  static class Pet {

    String name;

    Pet() {
    }

    String getName() {
      return name;
    }

    void setName(String name) {
      this.name = name;
    }

  }

  static class Cat extends Pet {

    public void setName(String name) {
      this.name = "Я - кот";
    }

  }
}
