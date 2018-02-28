package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String url = reader.readLine();
    int index = url.indexOf("?") + 1;
    String sub = url.substring(index);
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> alertList = new ArrayList<>();
    String[] strings = sub.split("&");
    for (String s : strings) {
      if (s.contains("=")) {
        String[] splitS = s.split("=");
        String potentialAlert = splitS[0];
        list.add(potentialAlert);
        if (potentialAlert.equals("obj")) {
          alertList.add(splitS[1]);
        }
      } else {
        list.add(s);
      }

      //add your code here
    }
    for (String s : list) {
      System.out.print(s + " ");
    }
    System.out.println("");
    for (String s : alertList) {
      try {
        alert(Double.parseDouble(s));
      } catch (Exception e) {
        alert(s);
      }
    }

  }

  private static void alert(double value) {
    System.out.println("double " + value);
  }

  private static void alert(String value) {
    System.out.println("String " + value);
  }
}
