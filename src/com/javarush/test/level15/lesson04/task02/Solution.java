package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

class Solution {

  public static void main(String[] args) {
    printMatrix(2, 3, "8");
  }

  private static void printMatrix(int m, int n, String value) {
    System.out.println("Заполняем объектами String");
    printMatrix(m, n, (Object) value);
  }

  private static void printMatrix(int m, int n, Object value) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(value);
      }
      System.out.println();
    }
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(int m, double n, Integer value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(short m, int n, Integer value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(float m, double n, Integer value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(short m, short n, Integer value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(float m, double n, String value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(short m, short n, String value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(float m, double n, Double value) {
    printMatrix(m, n, value);
  }

  @SuppressWarnings("InfiniteRecursion")
  private static void printMatrix(short m, short n, Float value) {
    printMatrix(m, n, value);
  }
}
