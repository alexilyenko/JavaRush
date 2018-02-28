package com.javarush.test.level24.lesson06.home02;

import java.text.SimpleDateFormat;

abstract class SuperDog {

  final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");

  @SuppressWarnings("SameReturnValue")
  String getSuperQuotes() {
    //some logic here
    return " *** ";
  }
}
