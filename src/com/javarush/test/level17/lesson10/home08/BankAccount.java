package com.javarush.test.level17.lesson10.home08;

import java.math.BigDecimal;

class BankAccount {

  @SuppressWarnings("FieldCanBeLocal")
  private final String owner;
  private BigDecimal balance;

  BankAccount(String owner) {
    this(BigDecimal.ZERO, owner);
  }

  private BankAccount(BigDecimal balance, String owner) {
    this.balance = balance;
    this.owner = owner;
  }

  private synchronized void deposit(BigDecimal money) {
    BigDecimal newBalance = balance.add(money);
    System.out.println("Добавляем " + money + ", на счету " + newBalance);
    balance = newBalance;
  }

  private synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
    BigDecimal newBalance = balance.subtract(money);

    if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
      throw new NotEnoughMoneyException();
    }

    balance = newBalance;
    System.out.println("Тратим " + money + ", на счету " + balance);
  }

  public void deposit(String money) {
    deposit(new BigDecimal(money));
  }

  public void withdraw(String money) throws NotEnoughMoneyException {
    withdraw(new BigDecimal(money));
  }
}
