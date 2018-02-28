package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Solution {

  public static void main(String[] args) throws IOException {
    String fileName = args[0];
    ArrayList<String> fileList = new ArrayList<>();
    String input;
    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
    while ((input = fileReader.readLine()) != null) {
      fileList.add(input);
    }
    fileReader.close();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();
    String[] stringArray;
    for (String aFileList : fileList) {
      stringArray = aFileList.split(" ");
      names.add(stringArray[0]);
      values.add(Double.parseDouble(stringArray[1]));
    }

    Map<String, Double> map = new TreeMap<>();
    for (int i = 0; i < names.size(); i++) {
      map.put(names.get(i), values.get(i));
    }

    ArrayList<String> ignoredNames = new ArrayList<>();
    //noinspection Duplicates
    for (int i = 0; i < names.size() - 1; i++) {
      for (int j = i + 1; j < names.size(); j++) {
        if (names.get(i).equals(names.get(j)) && !ignoredNames.contains(names.get(i))) {
          double tmp = values.get(i) + values.get(j);
          map.put(names.get(i), tmp);
          ignoredNames.add(names.get(i));
        }
      }
    }

    for (Map.Entry<String, Double> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
