package com.javarush.test.level16.lesson10.task04;

/* А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
*/

import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        TimeUnit.SECONDS.sleep(3);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod()
    {
        TestThread.cause = false;
    }

    public static class TestThread implements Runnable {
        public static boolean cause = true;
        public void run() {
            while(cause) {
                try {
                    System.out.println("he-he");
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
