package com.javarush.test.level14.lesson06.home01;

class RussianHen extends Hen {

  @Override
  String getDescription() {
    return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
        Country.RUSSIA, getCountOfEggsPerMonth());
  }

  @Override
  int getCountOfEggsPerMonth() {
    return 55;
  }
}
