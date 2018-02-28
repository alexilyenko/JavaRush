package com.javarush.test.level11.lesson11.home07;

/* Вторая правильная «цепочка наследования»
Расставь правильно «цепочку наследования» в классах: Carnivora (плотоядное животное), Cow (корова), Dog(собака), Pig(свинья), Animal (животное).
*/

class Solution {

  class Carnivora extends Animal {

  }

  private class Cow extends Animal {

  }

  private class Dog extends Carnivora {

  }

  private class Pig extends Animal {

  }

  class Animal {

  }
}
