package com.javarush.test.level22.lesson07.task02;

/* МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.
Должен быть вывод:
МНЕ нравится курс JavaRush
*/
class Solution {

  public static void main(String[] args) {
    System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
  }

  @SuppressWarnings("SameReturnValue")
  private static String getFormattedString() {
    return "%3$S %4$s %2$s %1$s";
  }
}
