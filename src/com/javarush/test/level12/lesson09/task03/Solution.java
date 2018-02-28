package com.javarush.test.level12.lesson09.task03;

/* Fly, Run, Swim для классов Dog, Fish, Bird, Airplane
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Dog(собака), Fish(рыба), Bird(птица), Airplane(самолет).
*/

public class Solution {

  interface Fly {

    void fly();
  }

  interface Run {

    void run();
  }

  interface Swim {

    void swim();
  }

  public class Dog implements Run, Swim {

    public void run() {
      System.out.println("Run!");
    }

    public void swim() {
      System.out.println("Swim!");
    }
  }

  public class Fish implements Swim {

    public void swim() {
      System.out.println("Swim!");
    }
  }

  public class Bird implements Fly, Run, Swim {

    public void fly() {
      System.out.println("Fly!");
    }

    public void run() {
      System.out.println("Run!");
    }

    public void swim() {
      System.out.println("Swim!");
    }

  }

  public class Airplane implements Fly, Run {

    public void fly() {
      System.out.println("Fly!");
    }

    public void run() {
      System.out.println("Run!");
    }

  }
}
