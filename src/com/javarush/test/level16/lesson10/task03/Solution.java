package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

import java.util.concurrent.TimeUnit;

public class Solution
{
    public static void main(String[] args) throws InterruptedException
    {
        TestThread thread = new TestThread();
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        thread.interrupt();
    }

    public static class TestThread extends Thread
    {
        public void run()
        {
                while (!isInterrupted())
                {}
        }
    }
}
