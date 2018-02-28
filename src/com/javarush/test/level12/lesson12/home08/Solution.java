package com.javarush.test.level12.lesson12.home08;

/* Интерфейсы к классу Human
Добавь как можно больше интерфейсов к классу Human, но чтобы он не стал абстрактным классом.
Добавлять методы в класс Human запрещается.
*/

class Solution {

  public static void main(String[] args) {
    Human human = new Human();
    System.out.println(human);
  }

  private interface Worker {

  }

  private interface Businessman {

  }

  private interface Secretary {

  }

  public interface Miner {

    void workVeryHard();
  }

  static class Human implements Businessman, Worker, Secretary {

  }
}
