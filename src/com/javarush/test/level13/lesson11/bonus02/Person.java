package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem {

  private final String name;
  private final String namePadezh;

  public Person(String name, String namePadezh) {
    this.name = name;
    this.namePadezh = namePadezh;
  }

  public String getNamePadezh() {
    return namePadezh;
  }

  public void pull(Person person) {
    System.out.println(this.name + " за " + person.getNamePadezh());
  }
}
