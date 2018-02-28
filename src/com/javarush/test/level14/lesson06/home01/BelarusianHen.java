package com.javarush.test.level14.lesson06.home01;


class BelarusianHen extends Hen {

  @Override
  String getDescription() {
    return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
        Country.BELARUS, getCountOfEggsPerMonth());
  }

  @Override
  int getCountOfEggsPerMonth() {
    return 200;
  }
}
