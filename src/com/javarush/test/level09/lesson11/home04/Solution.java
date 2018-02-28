package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

class Solution {

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
    SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    try {
      Date inputDate = dateFormat.parse(reader.readLine());
      System.out.println(outputDateFormat.format(inputDate).toUpperCase());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
