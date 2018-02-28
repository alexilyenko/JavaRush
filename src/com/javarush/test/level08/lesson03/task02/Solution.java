package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень, земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – овощ
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    Map<String, String> hash = new HashMap<>();
    hash.put("арбуз", "ягода");
    hash.put("банан", "трава");
    hash.put("вишня", "ягода");
    hash.put("груша", "фрукт");
    hash.put("дыня", "овощ");
    hash.put("ежевика", "куст");
    hash.put("жень-шень", "корень");
    hash.put("земляника", "ягода");
    hash.put("ирис", "цветок");
    hash.put("картофель", "клубень");

    for (Map.Entry<String, String> text : hash.entrySet()) {
      String value = text.getValue();
      String key = text.getKey();
      System.out.println(key + " - " + value);
    }
  }
}
