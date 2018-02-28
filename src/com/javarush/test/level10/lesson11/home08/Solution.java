package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

class Solution {

  public static void main(String[] args) {
    ArrayList<String>[] arrayOfStringList = createList();
    printList(arrayOfStringList);
  }

  @SuppressWarnings("unchecked")
  private static ArrayList<String>[] createList() {
    String s = "qwerttyuuiiiipipi";
    ArrayList<String> arraylist1 = new ArrayList<>();
    arraylist1.add(s);
    ArrayList<String> arraylist2 = new ArrayList<>();
    arraylist2.add(s);
    ArrayList<String> arraylist3 = new ArrayList<>();
    arraylist3.add(s);
    ArrayList<String> arraylist4 = new ArrayList<>();
    arraylist4.add(s);
    ArrayList<String> arraylist5 = new ArrayList<>();
    arraylist5.add(s);
    return new ArrayList[]{arraylist1, arraylist2, arraylist3, arraylist4, arraylist5};

  }

  private static void printList(ArrayList<String>[] arrayOfStringList) {
    for (ArrayList<String> list : arrayOfStringList) {
      for (String s : list) {
        System.out.println(s);
      }
    }
  }
}