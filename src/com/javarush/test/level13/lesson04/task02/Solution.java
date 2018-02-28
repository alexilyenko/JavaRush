package com.javarush.test.level13.lesson04.task02;

/* Исправление кода
Исправить код так, чтобы программа выполнялась и выводила "Я переводчик с английского".
Метод main менять нельзя!
*/

class Solution {

  public static void main(String[] args) {
    Translator translator = new Translator();
    System.out.println(translator.translate());
  }

  static class Translator {

    @SuppressWarnings("SameReturnValue")
    String translate() {
      return "Я переводчик с английского";
    }
  }


}
