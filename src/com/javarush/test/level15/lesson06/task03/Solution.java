package com.javarush.test.level15.lesson06.task03;

/* Максимально простой код 3
Упрости код:
- убери всё то, что будет генерироваться автоматически при компиляции
- убери все наследования классов, которые и так будут добавлены автоматически при компиляции
- убери все конструкторы, которые создаются и добавляются автоматически.
*/

class Solution {

  private interface Runnable {

  }

  class Machine implements Runnable {

  }

  private class Car extends Machine {

  }
}
