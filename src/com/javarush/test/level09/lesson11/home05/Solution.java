package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

class Solution {

  private static final char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    char[] mass = input.toCharArray();
    ArrayList<Character> glasnie = new ArrayList<>();
    ArrayList<Character> soglasnie = new ArrayList<>();
    for (char mas : mass) {
      if (isVowel(mas)) {
        glasnie.add(mas);
      } else if (mas != ' ') {
        soglasnie.add(mas);
      }
    }
    for (char a : glasnie) {
      System.out.print(a + " ");
    }
    System.out.println("");
    for (char a : soglasnie) {
      System.out.print(a + " ");
    }
  }

  //метод проверяет, гласная ли буква
  private static boolean isVowel(char c) {
    c = Character
        .toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

    for (char d : vowels)   //ищем среди массива гласных
    {
      if (c == d) {
        return true;
      }
    }
    return false;
  }
}
