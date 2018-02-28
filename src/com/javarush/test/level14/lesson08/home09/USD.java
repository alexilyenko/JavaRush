package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Алексей on 12.04.2014.
 */
public class USD extends Money {

  public USD(double amount) {
    super(amount);
  }

  public String getCurrencyName() {
    return "USD";
  }
}
