package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/


class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader readOn = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      int a = Integer.parseInt(readOn.readLine());
      list.add(a);
    }
    ArrayList<Integer> list1 = new ArrayList<>();

    for (Integer aList : list) {
      if ((aList % 3 == 0)) {
        list1.add(aList);
      }
    }

    ArrayList<Integer> list2 = new ArrayList<>();
    for (Integer aList : list) {
      if ((aList % 2 == 0)) {
        list2.add(aList);
      }
    }
    ArrayList<Integer> list3 = new ArrayList<>();

    for (Integer aList : list) {
      if ((aList % 3 != 0) & (aList % 2 != 0)) {
        list3.add(aList);
      }
    }

    printList(list1);
    printList(list2);
    printList(list3);
  }

  private static void printList(List<Integer> list) {
    for (Integer aList : list) {
      System.out.println(aList);
    }
  }
}
