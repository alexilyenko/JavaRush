package com.javarush.test.level20.lesson07.task04;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
@SuppressWarnings("FieldCanBeLocal")
class Solution implements Serializable {

  private transient final String pattern = "dd MMMM yyyy, EEEE";
  private String string;
  private transient Date currentDate;
  private transient int temperature;

  public Solution() {
  }

  private Solution(int temperature) {
    this.currentDate = new Date();
    this.temperature = temperature;
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    this.string = String.format("Today is %s, and current temperature is %s C",
        format.format(currentDate), temperature);
  }

  public static void main(String[] args) {
    System.out.println(new Solution(4));
  }

  @Override
  public String toString() {
    return this.string;
  }

}
