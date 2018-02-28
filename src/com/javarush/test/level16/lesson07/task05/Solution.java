package com.javarush.test.level16.lesson07.task05;

import java.util.concurrent.TimeUnit;

/* Аэропорт
1. Разберись, что делает программа.
2. Исправь метод takingOff(взлет) - сейчас он работает оооочень долго. Взлет должен занимать 100 миллисекунд.
3. Реализуй метод waiting по аналогии с методом takingOff. Время ожидания не должно превышать время взлета.
*/
class Solution {

  private static final Runway RUNWAY = new Runway();   //1 взлетная полоса

  public static void main(String[] args) {
    Plane plane1 = new Plane("Самолет #1");
    Plane plane2 = new Plane("Самолет #2");
    Plane plane3 = new Plane("Самолет #3");
  }

  private static void waiting() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException ignored) {
    }

  }

  private static void takingOff() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException ignored) {
    }
  }

  static class Plane extends Thread {

    Plane(String name) {
      super(name);
      start();
    }

    public void run() {
      boolean isAlreadyTakenOff = false;
      while (!isAlreadyTakenOff) {
        if (RUNWAY.getTakingOffPlane() == null) {    //если взлетная полоса свободна
          RUNWAY.setTakingOffPlane(this);
          System.out.println(getName() + " взлетает");
          takingOff();//взлетает
          System.out.println(getName() + " уже в небе");
          isAlreadyTakenOff = true;
          RUNWAY.setTakingOffPlane(null);
        } else if (!this
            .equals(RUNWAY.getTakingOffPlane())) {  //если взлетная полоса занята самолетом
          System.out.println(getName() + " ожидает");
          waiting(); //ожидает
        }
      }
    }
  }

  static class Runway { //взлетная полоса

    private Thread t;

    Thread getTakingOffPlane() {
      return t;
    }

    void setTakingOffPlane(Thread t) {
      synchronized (this) {
        this.t = t;
      }
    }
  }
}
