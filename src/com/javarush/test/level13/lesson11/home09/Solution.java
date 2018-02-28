package com.javarush.test.level13.lesson11.home09;

import java.awt.Color;

/* Один метод в классе
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Методы удалять нельзя!
*/

class Solution {

  private interface Animal {

    Color getColor();

    Integer getAge();
  }

  private static abstract class Fox implements Animal {

    @SuppressWarnings("SameReturnValue")
    public String getName() {
      return "Fox";
    }
  }
}
