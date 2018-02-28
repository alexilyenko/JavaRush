package com.javarush.test.level15.lesson06.task02;

/* Максимально простой код 2
Посмотри, что, связанное с конструкторами, может быть добавлено при компиляции, но в этой программе уже присутствует.
Упрости код - удали все конструкторы и вызовы конструкторов супер-классов, которые создаются и добавляются автоматически.

PS: Взаимосвязь между объектами классов NakedCat и NormalCat, SiamCat - Is-a (наследование): http://en.wikipedia.org/wiki/Is-a
http://cs7002.vk.me/c7007/v7007577/1411a/_dAiEola310.jpg
*/

class Solution {

  public static void main(String[] args) {
    SiamCat simka = new SiamCat("Simka");
    NakedCat nakedSimka = simka.shave();
  }

  static class NakedCat {

  }

  static class NormalCat extends NakedCat {

    NormalCat() {
    }

    NormalCat(String name) {
      System.out.println("My name is " + name);
    }

    NakedCat shave() {
      return this;
    }
  }

  static class SiamCat extends NormalCat {

    SiamCat(String name) {
      super(name);
    }
  }
}
