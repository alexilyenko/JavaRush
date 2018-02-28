package com.javarush.test.level14.lesson08.home09;

abstract class Money {

  private final double amount;

  Money(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public abstract String getCurrencyName();
}

