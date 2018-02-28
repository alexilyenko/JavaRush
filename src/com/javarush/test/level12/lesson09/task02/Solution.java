package com.javarush.test.level12.lesson09.task02;

/* Интерфейсы Fly, Run, Swim
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.
*/

class Solution {

  public interface Fly {

    boolean canFly();
  }

  public interface Run {

    int getSpeed();
  }

  public interface Swim {

    int getSpeed();
  }
}
