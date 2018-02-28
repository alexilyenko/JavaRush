package com.javarush.test.level22.lesson05.home01;

class TooShortStringFirstThreadException extends RuntimeException {

  TooShortStringFirstThreadException(StringIndexOutOfBoundsException e) {
  }
}
