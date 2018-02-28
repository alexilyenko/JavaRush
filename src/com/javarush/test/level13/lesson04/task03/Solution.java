package com.javarush.test.level13.lesson04.task03;

import java.awt.Color;

/* Интерфейс Animal
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Методы удалять нельзя!
*/

class Solution {

  private interface Animal {

    Color getColor();
  }

  private static abstract class Fox implements Animal {

    @SuppressWarnings("SameReturnValue")
    public String getName() {
      return "Fox";
    }
  }
}
