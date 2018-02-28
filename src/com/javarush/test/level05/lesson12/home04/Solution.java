package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 12 2012".
*/

import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {

  public static void main(String[] args) {
    SimpleDateFormat simpleDate = new SimpleDateFormat("dd MM yyyy");
    System.out.println(simpleDate.format(new Date()));
  }
}

