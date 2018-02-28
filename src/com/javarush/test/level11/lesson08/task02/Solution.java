package com.javarush.test.level11.lesson08.task02;

/* Доступ есть
Скрыть все внутренние переменные класса Cat, но только те, к которым остается доступ с помощью методов.
*/

class Solution {

  class Cat {

    final int weight;
    private String name;
    private int age;

    public Cat(String name, int age, int weight) {
      this.name = name;
      this.age = age;
      this.weight = weight;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}