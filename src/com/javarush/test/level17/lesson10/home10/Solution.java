package com.javarush.test.level17.lesson10.home10;

/* Посчитаем
1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
2. Исправь synchronized блок так, чтобы программа не вывела результат на экран
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        for (int i = 1; i <= 100; i++) {
            if (values[i] > 1) {
                System.out.println(String.format("%d повторилось %d раз", i, values[i]));
            } else if (values[i] == 0) {
                System.out.println(String.format("%d ни разу не встретилось", i));
            }
        }
    }

    public volatile static Integer count = 0;
    public volatile static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++)
            values[i] = 0;
    }

    public synchronized static void incrementCount() {
        count++;
    }

    public synchronized static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public synchronized void run() {
              do
                {
                        incrementCount();
                        values[getCount()]++;

                    try
                    {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException ignored)
                    {
                    }
                }
                while (getCount() < 100);
            }
        }
    }

