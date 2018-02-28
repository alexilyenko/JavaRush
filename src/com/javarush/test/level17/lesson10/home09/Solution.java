package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. выбросить исключение CorruptedDataException
4.2. очистить allLines от данных
Сигнатуру метода main не менять
*/

class Solution {

  private static final List<String> allLines = new ArrayList<>();
  private static final List<String> forRemoveLines = new ArrayList<>();

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1;
    String fileName2;
    try {
      fileName1 = reader.readLine();
      fileName2 = reader.readLine();
      reader.close();
      BufferedReader fReader1 = new BufferedReader(new FileReader(fileName1));
      String input;
      while ((input = fReader1.readLine()) != null) {
        allLines.add(input);
      }
      fReader1.close();
      BufferedReader fReader2 = new BufferedReader(new FileReader(fileName2));
      while ((input = fReader2.readLine()) != null) {
        forRemoveLines.add(input);
      }
      fReader2.close();
      new Solution().joinData();
    } catch (Exception ignore) {
    }

  }

  private synchronized void joinData() throws CorruptedDataException {
    if (allLines.containsAll(forRemoveLines)) {
      allLines.removeAll(forRemoveLines);
    } else {
      allLines.clear();
      throw new CorruptedDataException();
    }

  }
}
