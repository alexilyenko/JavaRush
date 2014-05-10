package com.javarush.test.level16.lesson13.home07;

import java.util.ArrayList;
import java.util.List;

/* Поиграем?
Три человека играют в игру. Каждый игрок(Gamer) характеризуется двумя параметрами: фамилией(name) и количеством действий в секунду (rating).
Нужно вывести в консоль ход игры и определить победителя и проигравших.
Итак...
1. Разберись, что делает программа.
1.1. List<String> steps хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
1.2. isWinnerFound показывает, найден победитель или нет.
1.3. метод sleep выбрасывает InterruptedException и принимает параметр типа long.
1.4. Игорки играют независимо друг от друга.

2. Реализуйте логику метода run так, чтобы для каждого игрока:
2.1. за 1 секунду через равные интервалы времени выводилось в консоль rating описанных в steps действий.
2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст. Пример: [Ivanov:Начало игры].
2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведите [getName() + ":победитель!"].
2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведите для них [getName() + ":проиграл"].
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            int start = 0;
             try
             {
                 while (!OnlineGame.isWinnerFound)
                 {
                     Thread.sleep(1000/rating);
                     if (start == OnlineGame.steps.size())
                             {
                                 System.out.println(this.getName() + ":победитель!");
                                 OnlineGame.isWinnerFound = true;
                                 break;
                            }
                             System.out.println(this.getName() + ":" + OnlineGame.steps.get(start));
                             start++;
                 }
                 } catch (InterruptedException e) {System.out.println(this.getName()+":проиграл");}
            //Add your code here - добавь код тут
        }
    }
}
