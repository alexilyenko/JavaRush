package com.javarush.test.level17.lesson10.home06;

/* Глажка
И снова быт...
Поставьте один synchronized, чтобы diana и igor гладили по-очереди, ведь утюг всего один!
*/

class Solution {

  public static void main(String[] args) {
    Person diana = new Person("Diana");
    Person igor = new Person("Igor");
  }

  static class Person extends Thread { //Человек

    Person(String name) {
      super(name);
      start();
    }

    @Override
    public void run() {
      Iron iron = takeIron();
      Clothes clothes = takeClothes();
      ironing(iron, clothes);
      returnIron();
    }

    Iron takeIron() {
      System.out.println("Taking an Iron");
      return new Iron();
    }

    @SuppressWarnings("UnusedReturnValue")
    Iron returnIron() {
      System.out.println("Returning the Iron");
      return new Iron();
    }

    Clothes takeClothes() {
      return new Clothes("T-shirt");
    }

    synchronized void ironing(Iron iron, Clothes clothes) {
      System.out.println(getName() + "'s ironing the " + clothes.name);
    }
  }

  static class Iron {

  } //Утюг

  static class Clothes {//Одежда
    final String name;

    Clothes(String name) {
      this.name = name;
    }
  }
}
