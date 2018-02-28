package com.javarush.test.level19.lesson10.home03;

import java.util.Date;

class Person {

  private final String name;
  private final Date birthday;

  public Person(String name, Date birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  private String getName() {
    return name;
  }

  private Date getBirthday() {
    return birthday;
  }

  public String toString() {
    return this.getName() + " " + this.getBirthday();
  }
}
