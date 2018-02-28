package com.javarush.test.level22.lesson05.home01;

class TooShortStringSecondThreadException extends RuntimeException {

  TooShortStringSecondThreadException(StringIndexOutOfBoundsException e) {
  }
}
