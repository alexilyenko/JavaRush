package com.javarush.test.level13.lesson02.task07;

/* Параметризованый интерфейс
В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
*/

public class Solution {

  interface SimpleObject<T> {

    SimpleObject<T> getInstance();
  }

  class StringObject implements SimpleObject<String> {

    public SimpleObject<String> getInstance() {
      return new StringObject();
    }
  }
}
