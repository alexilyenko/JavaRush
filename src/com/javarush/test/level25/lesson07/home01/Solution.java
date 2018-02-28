package com.javarush.test.level25.lesson07.home01;

/* Не валять дурака
Восстановите логику класса TaskManipulator.
*/


class Solution {

  /*
   Output:
   first
   first
   second
   second
   second
   third
   fifth
   */
  public static void main(String[] args) throws InterruptedException {
    CustomThreadManipulator manipulator = new TaskManipulator();

    manipulator.start("first");
    Thread.sleep(150);
    manipulator.stop();

    manipulator.start("second");
    Thread.sleep(250);
    manipulator.stop();

    manipulator.start("third");
    Thread.sleep(50);
    manipulator.stop();

    manipulator.start("forth");
    manipulator.stop();

    manipulator.start("fifth");
    Thread.sleep(1);
    manipulator.stop();
  }
}


