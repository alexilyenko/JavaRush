package com.javarush.test.level26.lesson08.task01;

import java.util.concurrent.atomic.AtomicInteger;


/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
class Solution {

  static class IntegerHolder {

    private final AtomicInteger hi = new AtomicInteger();

    public synchronized int get() {
      return hi.get();
    }

    public synchronized void set(int i) {
      hi.set(i);
    }
  }
}
