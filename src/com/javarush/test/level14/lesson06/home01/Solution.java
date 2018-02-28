package com.javarush.test.level14.lesson06.home01;

/**
 * Написать Фабрику(Factory) по производству кур(Hen) <b/>
 * 1. Создать класс Hen <b/>
 * 1.1 Сделать его абстрактным <b/>
 * 1.2 Добавить в класс абстрактный метод  int getCountOfEggsPerMonth() <b/>
 * 1.3 Добавить в класс метод String getDescription(), который возвращает строку "Я курица." <b/>
 * 2. Создать класс RussianHen, который наследуется от Hen <b/>
 * 3. Создать класс UkrainianHen, который наследуется от Hen <b/>
 * 4. Создать класс MoldovanHen, который наследуется от Hen <b/>
 * 5. Создать класс BelarusianHen, который наследуется от Hen <b/>
 * 6. В каждом из четырех последних классов написать свою реализацию метода getCountOfEggsPerMonth. Методы должны
 * возвращать количество яиц в месяц от данного типа куриц. <b/>
 * 7. В каждом из четырех последних классов написать свою реализацию метода getDescription. Методы должны возвращать
 * строку вида: <getDescription() родительского класса>  + <" Моя страна - SSSSS. Я несу N яиц в месяц."> <b/>
 * где SSSSS - название страны <b/>
 * где N - количество яиц в месяц <b/>
 * 8. В классе HenFactory реализовать меетод getHen, который возвращает соответствующую стране породу кур. <b/>
 * 9. Все классы должны быть в отдельных файлах
 */

class Solution {

  public static void main(String[] args) {
    Hen hen = HenFactory.getHen("Belarus");
    hen.getDescription();
  }

  static class HenFactory {

    @SuppressWarnings("SameParameterValue")
    static Hen getHen(String country) {
      Hen hen = null;

      if (country.equals(Country.UKRAINE)) {
        hen = new UkrainianHen();
      }
      if (country.equals(Country.RUSSIA)) {
        hen = new RussianHen();
      }
      if (country.equals(Country.MOLDOVA)) {
        hen = new MoldovanHen();
      }
      if (country.equals(Country.BELARUS)) {
        hen = new BelarusianHen();
      }

      return hen;
    }
  }
}
