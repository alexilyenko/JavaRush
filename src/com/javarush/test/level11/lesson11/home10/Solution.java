package com.javarush.test.level11.lesson11.home10;

/* Пятая правильная «цепочка наследования»
Расставь правильно «цепочку наследования» в классах: House (дом), Cat (кот), Dog(собака), Car (машина), Animal(животное), Assets (имущество).
*/

class Solution {

  private class House extends Assets {

  }

  private class Cat extends Animal {

  }

  private class Car extends Assets {

  }

  private class Dog extends Animal {

  }

  class Animal {

  }

  class Assets {

  }
}
