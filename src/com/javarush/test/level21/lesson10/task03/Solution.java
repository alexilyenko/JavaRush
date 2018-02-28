package com.javarush.test.level21.lesson10.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Найти и исправить ошибку
Найти и исправить ошибку
*/
class Solution {

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      try {
        new Solution().readFile("d:/1.txt");
      } catch (Throwable throwable) {
        System.out.println(i + " " + throwable.getClass().getSimpleName());
      }
    }
  }

  private void readFile(String path) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      System.out.println(br.readLine());
      dispose();
    } catch (IOException ignored) {
      dispose();
    }
    System.out.println("finally");
  }

  private void dispose() {
    throw new RuntimeException("no matter");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("inside finalize - before throwing");
    dispose();
    System.out.println("inside finalize - after throwing");
  }
}
