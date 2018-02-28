package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int mid;
    if (a < b && a < c) {
      if (b > c) {
        mid = c;
      } else {
        mid = b;
      }
    } else if (b < a && b < c) {
      if (a > c) {
        mid = c;
      } else {
        mid = a;
      }
    } else {
      if (a > b) {
        mid = b;
      } else {
        mid = a;
      }
    }
    System.out.println(mid);
  }
}
