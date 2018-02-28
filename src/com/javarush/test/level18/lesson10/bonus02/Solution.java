package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = bufferedReader.readLine();
    bufferedReader.close();
    StringBuilder productName = new StringBuilder();

    for (int i = 1; i < args.length - 2; i++) {
      productName.append(args[i]).append(" ");
    }
    String trueProductName = setSpaces(productName.toString(), 30);

    String truePrice = setSpaces(args[args.length - 2], 8);
    String trueQuantity = setSpaces(args[args.length - 1], 4);

    String id = getId(fileName);
    id = setSpaces(id, 8);
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
    printWriter.println(id + trueProductName + truePrice + trueQuantity);
    printWriter.close();

  }

  private static String getId(String fileName) throws IOException {
    ArrayList<Long> allIds = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
    String line;
    Long currentId;
    while ((line = bufferedReader.readLine()) != null) {
      line = line.substring(0, 8).replaceAll("\\s", "");
      currentId = Long.parseLong(line);
      allIds.add(currentId);
    }
    bufferedReader.close();
    Long maxId = Collections.max(allIds);
    Long MyId = maxId + 1;
    return MyId.toString();
  }


  @SuppressWarnings("Duplicates")
  private static String setSpaces(String previousName, int count) {
    String trueName;
    if (previousName.length() > count) {
      trueName = previousName.substring(0, count);
    } else {
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < (count - previousName.length()); i++) {
        s.append(" ");
      }
      trueName = previousName + s;
    }
    return trueName;
  }
}
