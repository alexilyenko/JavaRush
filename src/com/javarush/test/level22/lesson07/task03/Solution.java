package com.javarush.test.level22.lesson07.task03;

import java.util.Date;

/* Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
31:10:13 15:59:59
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tT";
    }
}
