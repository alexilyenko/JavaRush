package com.javarush.test.level17.lesson10.home08;

/* Банкомат
Разберись, как работает программа
Во время тестирования лог содержит следующее:
.....
Добавляем 100, на счету 1100
Добавляем 100, на счету 1200
Тратим 1000, на счету 100
Недостаточно денег
.....

Создан баг: При списании денег со счета теряются деньги
Найти и исправить ошибку
*/

import java.util.concurrent.TimeUnit;

class Bankomat {

  private static final BankAccount account = new BankAccount("Amigo");
  private static volatile boolean isStopped;
  private static final Thread addMoney = new Thread() {
    @Override
    public void run() {
      while (!isStopped) {
        account.deposit("1000");            //кладем на счет
        try {
          TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
          break;
        }
      }
    }
  };

  public static void main(String[] args) throws InterruptedException {
    addMoney.start();
    new SpendThread();
    new SpendThread();
    new SpendThread();
    TimeUnit.MILLISECONDS.sleep(4000);
    isStopped = true;
  }

  static class SpendThread extends Thread {

    SpendThread() {
      start();
    }

    @Override
    public void run() {
      while (!isStopped) {
        try {
          account.withdraw("100");             //снимаем со счета
        } catch (NotEnoughMoneyException e) {
          System.out.println("Недостаточно денег");
        }
        try {
          TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
          break;
        }
      }
    }
  }
}
