package com.javarush.test.level10.lesson04.task03;

/* Задача №3 на преобразование целых типов
Расставь где нужно оператор приведения типа:
float f = 333.50;
int i = f;
byte b = i;
*/

class Solution {

  public static void main(String[] args) {
    float f = (float) 333.50;
    int i = (int) f;
    byte b = (byte) i;
  }
}
