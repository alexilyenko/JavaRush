package com.javarush.test.level14.lesson08.home03;

interface Person {

  class User implements Person {

    void live() {
      System.out.println("Usually I just live");
    }
  }

  class Looser implements Person {

    void doNothing() {
      System.out.println("Usually I do nothing");
    }
  }

  class Coder implements Person {

    void coding() {
      System.out.println("Usually I create code");
    }
  }

  class Proger implements Person {

    void enjoy() {
      System.out.println("Wonderful life!");
    }
  }

}
