package com.javarush.test.level07.lesson04.task05;

import java.util.Scanner;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    int[] mass1 = new int[20];
    int[] mass2 = new int[10];
    int[] mass3 = new int[10];
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < mass1.length; i++) {
      mass1[i] = scan.nextInt();
    }
    System.arraycopy(mass1, 0, mass2, 0, mass2.length);
    for (int i = 0; i < mass3.length; i++) {
      mass3[mass3.length - 1 - i] = mass1[mass1.length - 1 - i];
    }
    for (int aMass3 : mass3) {
      System.out.println(aMass3);
    }
  }
}
