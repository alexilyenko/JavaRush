package com.javarush.test.level12.lesson12.home07;

/* Fly, Run, Swim для классов Duck, Penguin, Toad
Есть интерфейсы Fly(летать), Swim(плавать), Run(бегать).
Добавь эти интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба)
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

  public class Duck implements Fly, Run, Swim {

    public void run() {
      System.out.println("I'm running!");
    }

    public void fly() {
      System.out.println("I'm flying!");
    }

    public void swim() {
      System.out.println("I'm swimming!");
    }

  }

  public class Penguin implements Run, Swim {

    public void run() {
      System.out.println("I'm running!");
    }

    public void swim() {
      System.out.println("I'm swimming!");
    }

  }

  public class Toad implements Swim {

    public void swim() {
      System.out.println("I'm swimming!");
    }

  }
}
