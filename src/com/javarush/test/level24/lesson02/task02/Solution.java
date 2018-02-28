package com.javarush.test.level24.lesson02.task02;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

/* Так-с...сопоставим
Исправьте ошибки: переместите методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удалите.
*/
public class Solution {

  private static class A implements Serializable {

  }

  private static class B implements Remote {

  }

  public static class C extends ArrayDeque {

    public C clone() {
      return (C) super.clone();
    }
  }

  private static class D implements EventListener {

  }

}
