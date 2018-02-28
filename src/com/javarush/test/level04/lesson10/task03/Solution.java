package com.javarush.test.level04.lesson10.task03;

import java.util.Scanner;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    int number = scan.nextInt();
    int x = 0;
    while (x < number) {
      System.out.println(str);
      x++;
    }
  }
}
