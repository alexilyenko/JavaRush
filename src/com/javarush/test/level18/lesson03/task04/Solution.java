package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

class Solution {

  private static final List<Integer> integerList = new ArrayList<>();
  private static final Map<Integer, Integer> map = new HashMap<>();
  private static final List<Integer> countList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();
    FileInputStream inputStream = new FileInputStream(fileName);

    int count;
    int minValue;

    while (inputStream.available() > 0) {
      int data = inputStream.read();
      integerList.add(data);
    }

    for (Integer i : integerList) {
      count = Collections.frequency(integerList, i);
      map.put(i, count);
    }

    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
      Integer value = pair.getValue();
      countList.add(value);

    }

    minValue = countList.get(0);
    for (int i = 1; i < countList.size(); i++) {
      if (minValue > countList.get(i)) {
        minValue = countList.get(i);
      }
    }

    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
      Integer key = pair.getKey();

      if (pair.getValue().equals(minValue)) {
        System.out.print(key + " ");
      }
    }

    reader.close();
    inputStream.close();


  }
}

