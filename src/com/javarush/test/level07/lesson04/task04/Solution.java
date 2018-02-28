package com.javarush.test.level07.lesson04.task04;

import java.util.Scanner;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    int[] mass = new int[10];
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < mass.length; i++) {
      mass[mass.length - 1 - i] = scan.nextInt();
    }
    for (int mas : mass) {
      System.out.println(mas);
    }
  }
}
