package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке. Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка, а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<String> words = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      words.add(reader.readLine());
    }

    Map<String, Integer> map = countWords(words);

    for (Map.Entry<String, Integer> pair : map.entrySet()) {
      System.out.println(pair.getKey() + " " + pair.getValue());
    }
  }

  private static Map<String, Integer> countWords(ArrayList<String> list) {
    HashMap<String, Integer> result = new HashMap<>();
    for (String aList : list) {
      result.put(aList, 1);
    }

    for (int i = 0; i < list.size(); i++) {
      String currentWord = list.get(i);
      for (int k = i + 1; k < list.size(); k++) {
        if (currentWord.equals(list.get(k))) {
          result.put(currentWord, (result.get(currentWord) + 1));
          list.remove(k);
          k--;
        }
      }

    }

    return result;
  }

}
