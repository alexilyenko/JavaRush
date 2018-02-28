package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

class Solution {

  public static void main(String[] args) {
    Cat cat1 = new Cat("Vaska", 1, 25, 5);
    Cat cat3 = new Cat("Petka", 2, 34, 4);
    Cat cat2 = new Cat("Mashka", 1, 18, 1);
    cat1.fight(cat2);
    System.out.println(cat1.name + " сильнее " + cat2.name);
    cat1.fight(cat3);
    System.out.println(cat1.name + " сильнее " + cat3.name);
    cat2.fight(cat3);
    System.out.println(cat3.name + " сильнее " + cat2.name);
  }

  static class Cat {

    static int count = 0;
    static int fightCount = 0;
    final String name;
    final int age;
    final int weight;
    final int strength;

    Cat(String name, int age, int weight, int strength) {
      count++;
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.strength = strength;
    }

    @SuppressWarnings("UnusedReturnValue")
    boolean fight(Cat anotherCat) {
      fightCount++;
      int agePlus = this.age > anotherCat.age ? 1 : 0;
      int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
      int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;
      int score = agePlus + weightPlus + strengthPlus;
      return score > 2; //эквивалентно return score > 2 ? true : false;
    }
  }
}
