package com.javarush.test.level20.lesson10.home05;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution implements Serializable {

  enum Sex implements Serializable {
    MALE,
    FEMALE
  }

  static class Person implements Serializable {

    final transient String greetingString;
    final String firstName;
    final String lastName;
    final transient String fullName;
    final String country;
    final Sex sex;
    final transient PrintStream outputStream;
    final transient Logger logger;

    Person(String firstName, String lastName, String country, Sex sex) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.fullName = String.format("%s, %s", lastName, firstName);
      this.greetingString = "Hello, ";
      this.country = country;
      this.sex = sex;
      this.outputStream = System.out;
      this.logger = Logger.getLogger(String.valueOf(Person.class));
    }
  }
}
