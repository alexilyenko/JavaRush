package com.javarush.test.level04.lesson02.task01;

/* Реализовать метод setName
Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной private String name равное переданному параметру String name.
*/

class Cat {

  @SuppressWarnings("FieldCanBeLocal")
  private String name;

  public void setName(String name) {
    this.name = name;
  }
}
