package com.javarush.test.level19.lesson03.task04;

import java.util.Date;

public class Person {

  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final Date birthDate;

  public Person(String firstName, String middleName, String lastName, Date birthDate) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
  }
}
