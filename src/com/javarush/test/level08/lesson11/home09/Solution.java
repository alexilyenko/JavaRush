package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

class Solution {

  public static void main(String[] args) {
    String s = "MAY 1 2013";
    boolean a = isDateOdd(s);
  }

  @SuppressWarnings("deprecation")
  private static boolean isDateOdd(String date) {
    boolean bool;
    Date date1 = new Date(date);
    Date ms = new Date(date);
    ms.setHours(0);
    ms.setMinutes(0);
    ms.setSeconds(0);
    ms.setMonth(0);
    ms.setDate(1);
    long num = date1.getTime() - ms.getTime();
    long dayMs = 24 * 60 * 60 * 1000;
    int day = (int) (num / dayMs);
    bool = day % 2 == 0;
    return bool;
  }
}
