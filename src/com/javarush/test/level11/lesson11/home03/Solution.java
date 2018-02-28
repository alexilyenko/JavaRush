package com.javarush.test.level11.lesson11.home03;

/* Эволюция
Написать четыре класса: Fish(Рыбы), Animal(Животные), Ape(Обезьяны), Human (Человек).
Унаследовать животных от рыб, обезьян от животных и человека от обезьян.
*/

class Solution {

  class Fish {

  }

  class Animal extends Fish {

  }

  class Ape extends Animal {

  }

  private class Human extends Ape {

  }

}
