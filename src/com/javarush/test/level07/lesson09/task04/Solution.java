package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String str = bis.readLine();
      list.add(str);
    }
    list = fix(list);

    for (String s : list) {
      System.out.println(s);
    }
  }

  private static ArrayList<String> fix(ArrayList<String> list) {
    for (int i = 0; i < list.size(); ) {
      if (list.get(i).contains("р") && list.get(i).contains("л")) {
        i++;
      } else if (list.get(i).contains("л")) {
        list.add(i, list.get(i));
        i += 2;
      } else if (list.get(i).contains("р")) {
        list.remove(i);
      } else {
        i++;
      }
    }
    return list;
  }
}