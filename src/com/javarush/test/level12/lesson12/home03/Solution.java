package com.javarush.test.level12.lesson12.home03;

/* Добавь один метод в класс Cat
Добавь один метод в класс Cat так, чтобы программа ничего не выводила на экран.
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

    final String getName() {
      return name;
    }

    void setName(String name) {
      this.name = name;
    }

  }

  static class Cat extends Pet {

    public void setName(String name) {
      this.name = "";
    }

  }
}
