package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by ailenko on 14.04.2014.
 */
class Plane implements Flyable {

  @SuppressWarnings("FieldCanBeLocal")
  private final int passengers;

  Plane(int passengers) {
    this.passengers = passengers;
  }

}
