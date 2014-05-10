package com.javarush.test.level08.lesson11.home09;

import java.util.Date;/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "MAY 1 2013";
        boolean a = isDateOdd(s);
    }

    public static boolean isDateOdd(String date)
    {
        boolean bool;
        Date date1 = new Date(date);
        Date ms = new Date(date);
        ms.setHours(0);
        ms.setMinutes(0);
        ms.setSeconds(0);
        ms.setMonth(0);
        ms.setDate(1);
        long num = date1.getTime()-ms.getTime();
        long dayMs = 24 * 60 * 60 * 1000;
        int day = (int) (num/dayMs);
        bool = day % 2 == 0;
        return bool;
    }
}
