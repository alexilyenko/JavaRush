package com.javarush.test.level16.lesson05.task05;

/* Расставь вызовы методов join()
1. Разберитесь, что делает программа.
2. Расставь вызовы методов join() так, чтобы для каждой кошки выполнялось следующее:
2.1. Сначала кошка рожает котят.
2.2. Потом все котята вылазят из корзинки в произвольном порядке.
2.3. В конце кошка собирает их назад в корзинку.
2.4. Все события для одной кошки могут быть перемешаны с событями для другой кошки.
*/

class Solution {

  public static void main(String[] args) {
    Cat cat1 = new Cat("Мурка");
    Cat cat2 = new Cat("Пушинка");
  }

  private static void investigateWorld() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException ignored) {
    }
  }

  static class Cat extends Thread {

    final Kitten kitten1;
    final Kitten kitten2;

    Cat(String name) {
      super(name);
      kitten1 = new Kitten("Котенок 1, мама - " + getName());
      kitten2 = new Kitten("Котенок 2, мама - " + getName());
      start();
    }

    public void run() {
      System.out.println(getName() + " родила 2 котенка");
      try {
        initAllKitten();
      } catch (InterruptedException ignored) {
      }
      System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
    }

    private void initAllKitten() throws InterruptedException {
      kitten1.start();
      kitten2.start();
      kitten1.join();
      kitten2.join();
    }
  }

  static class Kitten extends Thread {

    Kitten(String name) {
      super(name);
    }

    public void run() {
      System.out.println(getName() + ", вылез из корзинки");
      investigateWorld();
    }
  }
}
