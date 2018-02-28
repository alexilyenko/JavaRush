package com.javarush.test.level17.lesson10.bonus03;

public class Order {

  private final long time;
  private final byte tableNumber;

  Order(byte tableNumber) {
    time = (long) (Math.random() * 200);
    this.tableNumber = tableNumber;
  }

  public long getTime() {
    return time;
  }

  public byte getTableNumber() {
    return tableNumber;
  }
}
