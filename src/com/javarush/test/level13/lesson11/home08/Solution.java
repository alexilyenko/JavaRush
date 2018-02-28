package com.javarush.test.level13.lesson11.home08;

/* Интерфейс Updatable в классе Screen
Реализовать интерфейс Updatable в классе Screen.
*/

class Solution {

  private interface Selectable {

  }

  private interface Updatable extends Selectable {

  }

  private class Screen implements Updatable {

  }
}
