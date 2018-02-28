package com.javarush.test.level15.lesson02.task02;

/* ООП - наследование животных
1. Создать public static класс Goose(Гусь).
2. Создать public static класс Dragon(Дракон).
3. Унаследовать класс Goose от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
4. Унаследовать класс Dragon от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
5. В классах Goose и Dragon переопределить метод String getSize(), расширить видимость до максимальной.
6. В классе Goose метод getSize должен возвращать строку "Гусь маленький, " + [getSize родительского класса].
7. В классе Dragon метод getSize должен возвращать строку "Дракон большой, " + [getSize родительского класса].
*/

class Solution {
  //добавьте классы Goose и Dragon тут

  static class BigAnimal {

    String getSize() {
      return "как динозавр";
    }
  }

  static class SmallAnimal {

    String getSize() {
      return "как кошка";
    }
  }

  static class Goose extends SmallAnimal {

    public String getSize() {
      return "Гусь маленький, " + super.getSize();
    }
  }

  static class Dragon extends BigAnimal {

    public String getSize() {
      return "Дракон большой, " + super.getSize();
    }
  }
}
