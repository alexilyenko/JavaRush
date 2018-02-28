package com.javarush.test.level13.lesson04.task01;

/* Переводчик с английского
1. Создать класс EnglishTranslator, который наследуется от Translator.
2. Реализовать все абстрактные методы.
3. Подумай, что должен возвращать метод getLanguage.
4. Программа должна выводить на экран "Я переводчик с английского".
5. Метод main менять нельзя.
*/

public class Solution {

  public static void main(String[] args) {
    EnglishTranslator englishTranslator = new EnglishTranslator();
    System.out.println(englishTranslator.translate());
  }

  static abstract class Translator {

    @SuppressWarnings("SameReturnValue")
    protected abstract String getLanguage();

    String translate() {
      return "Я переводчик с " + getLanguage();
    }
  }

  protected static class EnglishTranslator extends Translator {

    public String getLanguage() {
      return "английского";
    }
  }

}
