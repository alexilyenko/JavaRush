package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

class Solution {

  public static void main(String[] args) {
    Integer big = 85;
    int a = 21;
    print(a);
    print(big);

  }

  private static void print(int a) {
    System.out.print(a);
  }

  private static void print(Integer a) {
    System.out.print(a);
  }
}
