package com.javarush.test.level16.lesson13.home03;

/* Рекурсивное создание нитей
1. Внутри класса Solution создай нить public static GenerateThread.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй countCreatedThreads.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName(). Пример: [8 created]
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.1. нить.
5. В итоге должно быть выведено в консоль 15 строк.
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread()        {
            super(++countCreatedThreads + "");
            start();
        }

        @Override
        public String toString()        {
            return getName() + " created";
        }

        @Override
        public void run() {
            while(countCreatedThreads < count) {
                System.out.println(new GenerateThread());
            }
        }
    }
}