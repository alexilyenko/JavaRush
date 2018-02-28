package com.javarush.test.level08.lesson11.bonus01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

class Solution {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("January", 1);
    map.put("February", 2);
    map.put("March", 3);
    map.put("April", 4);
    map.put("May", 5);
    map.put("June", 6);
    map.put("July", 7);
    map.put("August", 8);
    map.put("September", 9);
    map.put("October", 10);
    map.put("November", 11);
    map.put("December", 12);
    Scanner scan = new Scanner(System.in);
    String month = scan.nextLine();
    System.out.println(month + " is " + map.get(month) + " month");
  }
}