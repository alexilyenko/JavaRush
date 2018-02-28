package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

class Solution {

  static class OurPresident {

    private static final OurPresident president;

    static {
      synchronized (OurPresident.class) {
        president = getOurPresident();
      }
    }

    private OurPresident() {
    }

    static OurPresident getOurPresident() {
      return president;
    }
  }
}
