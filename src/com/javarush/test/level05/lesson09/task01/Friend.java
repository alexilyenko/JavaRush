package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

class Friend {

  private final String name;
  private int age;
  @SuppressWarnings("FieldCanBeLocal")
  private boolean gender;

  public Friend(String name) {
    this.name = name;
  }

  public Friend(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Friend(String name, int age, boolean gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }
}