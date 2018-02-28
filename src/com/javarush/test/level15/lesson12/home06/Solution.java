package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/

class Solution {

  static {
    init();
  }

  static {
    System.out.println("Static block");
  }

  private final int i = 6;
  private final String name = "First name";

  {
    System.out.println("non-static block");
    printAllFields(this);
  }

  private Solution() {
    System.out.println("Solution constructor");
    printAllFields(this);
  }

  private static void init() {
    System.out.println("static void init()");
  }

  public static void main(String[] args) {
    System.out.println("public static void main");
    Solution s = new Solution();
  }

  private static void printAllFields(Solution obj) {
    System.out.println("static void printAllFields");
    System.out.println(obj.i);
    System.out.println(obj.name);

  }
}
