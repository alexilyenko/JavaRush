package com.javarush.test.level11.lesson06.task01;

/* Лошадь и пегас
Написать два класса: Horse (лошадь) и Pegas (пегас).
Унаследовать пегаса от лошади.
*/

class Solution {

  class Horse {

    final String name;

    Horse(String name) {
      this.name = name;
    }

  }

  private class Pegas extends Horse {

    public Pegas(String name) {
      super(name);
    }

  }
}
