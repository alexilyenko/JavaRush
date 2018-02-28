package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    int age = scan.nextInt();
    if (age < 18) {
      System.out.println("Подрасти еще");
    }
  }
}
