package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

  public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(new File("d:\\1.txt"));
    PersonScanner adapter = new PersonScannerAdapter(s);
    System.out.println(adapter.read());
    adapter.close();
  }

  public static class PersonScannerAdapter implements PersonScanner {

    private final Scanner scanner;

    PersonScannerAdapter(Scanner scanner) {
      this.scanner = scanner;
    }

    @Override
    public Person read() {
      if (scanner.hasNext()) {
        String[] inputArray = scanner.nextLine().split(" ");
        Date birthDate = (new GregorianCalendar(Integer.parseInt(inputArray[5]),
            Integer.parseInt(inputArray[4]) - 1, Integer.parseInt(inputArray[3]))).getTime();
        return new Person(inputArray[1], inputArray[2], inputArray[0], birthDate);
      }
      return null;
    }

    @Override
    public void close() {
      scanner.close();
    }
  }
}

