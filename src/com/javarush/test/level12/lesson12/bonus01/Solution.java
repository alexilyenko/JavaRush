package com.javarush.test.level12.lesson12.bonus01;

/* Нужно исправить программу, чтобы компилировалась и работала
Расставить правильно ключевые слова abstract, чтобы программа компилировалась (там где надо и не надо).
*/

public class Solution {

  public static void main(String[] args) {
    Horse horse = new Pegas();
    horse.run();
  }

  private interface Fly {

  }

  static abstract class Horse {

    @SuppressWarnings("EmptyMethod")
    void run() {
    }
  }

  static class Pegas extends Horse implements Fly {

  }

  public static abstract class SwimPegas extends Pegas {

    public abstract void swim();
  }

}
