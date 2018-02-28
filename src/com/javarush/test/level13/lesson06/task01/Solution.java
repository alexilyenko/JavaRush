package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

class Solution {

  private interface Moveable //может двигаться
  {

  }

  private interface Eatable  //может быть съеден
  {

  }

  private interface Eat  //может кого-нибудь съесть
  {

  }

  private class Cat implements Moveable, Eatable, Eat {

  }

  private class Mouse implements Moveable, Eatable {

  }

  private class Dog implements Moveable, Eat {

  }
}
