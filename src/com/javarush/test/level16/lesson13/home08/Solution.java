package com.javarush.test.level16.lesson13.home08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Кто первый встал - того и тапки
1. Разберись, что делает программа.
1.1. Каждая нить должна читать с консоли слова. Используйте готовый static BufferedReader reader.
1.2. Используй static byte countReadStrings, чтобы посчитать, сколько слов уже считано с консоли всеми нитями.

2. Реализуйте логику метода run:
2.1. Пока нить не прервана (!isInterrupted) читайте с консоли слова и добавляйте их в поле List<String> result.
2.2. Используй countReadStrings для подсчета уже считанных с консоли слов.
*/

class Solution {

  private static final BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));
  private static volatile byte countReadStrings;

  public static void main(String[] args) throws IOException {
    //read count of strings
    int count = Integer.parseInt(reader.readLine());

    //init threads
    ReaderThread consolReader1 = new ReaderThread();
    ReaderThread consolReader2 = new ReaderThread();
    ReaderThread consolReader3 = new ReaderThread();

    //noinspection StatementWithEmptyBody
    while (count > countReadStrings) {
    }

    consolReader1.interrupt();
    consolReader2.interrupt();
    consolReader3.interrupt();
    System.out.println("#1:" + consolReader1);
    System.out.println("#2:" + consolReader2);
    System.out.println("#3:" + consolReader3);

    reader.close();
  }

  static class ReaderThread extends Thread {

    private final List<String> result = new ArrayList<>();

    ReaderThread() {
      start();
    }

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public void run() {
      while (!isInterrupted()) {
        try {
          String input = reader.readLine();
          result.add(input);
          countReadStrings++;
        } catch (IOException ignored) {
        }

      }
    }

    @Override
    public String toString() {
      String s = result.toString();
      return s.substring(1, s.length() - 1);
    }
  }
}

