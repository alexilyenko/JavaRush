package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int nod = 1;
    for (int i = 2; i <= a; i++) {
      if ((a % i == 0) && (b % i == 0)) {
        nod = i;
      }
    }
    System.out.println(nod);
  }
}
