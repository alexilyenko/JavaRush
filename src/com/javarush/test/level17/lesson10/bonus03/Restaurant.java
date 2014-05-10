package com.javarush.test.level17.lesson10.bonus03;

/* Ресторан
1.Разберись, что делает программа. Официант почему-то не относит приготовленные блюда назад к столам :(
2.Исправь ошибку.
Подсказка: это одна строчка
*/

public class Restaurant {
    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        waiterTarget.continueWorking = false;
        cookTarget.continueWorking = false;
    }
}
