package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Алексей on 12.04.2014.
 */
public class Hrivna extends Money {

  Hrivna(double amount) {
    super(amount);
  }

  public String getCurrencyName() {
    return "HRN";
  }
}
