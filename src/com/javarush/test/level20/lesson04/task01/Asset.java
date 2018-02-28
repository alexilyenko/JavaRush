package com.javarush.test.level20.lesson04.task01;

import java.io.Serializable;

class Asset implements Serializable {

  private final String name;
  private double price;

  public Asset(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
