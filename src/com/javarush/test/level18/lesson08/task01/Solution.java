package com.javarush.test.level18.lesson08.task01;

/* Wrapper (Decorator)
Разберись, что делает программа
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl
*/

class Solution {

  public static void main(String[] args) {
    new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
  }

  static class RunnableImpl implements Runnable {

    @Override
    public void run() {
      System.out.println("RunnableImpl body");
    }
  }

  static class DecoratorRunnableImpl implements Runnable {

    private final Runnable component;

    DecoratorRunnableImpl(Runnable component) {
      this.component = component;
    }

    @Override
    public void run() {
      System.out.print("DecoratorRunnableImpl body ");
      component.run();
    }
  }

  static class DecoratorMyRunnableImpl implements Runnable {

    private final Runnable component;

    DecoratorMyRunnableImpl(Runnable component) {
      this.component = component;
    }

    @Override
    public void run() {
      System.out.print("DecoratorMyRunnableImpl body ");
      component.run();
    }
  }

}
