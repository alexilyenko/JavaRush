package com.javarush.test.level20.lesson02.task01;

class Asset {

  private final String name;
  private double price;

  Asset(String name) {
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
