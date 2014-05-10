package com.javarush.test.level10.lesson04.task04;

/* Задача №4 на преобразование целых типов
Расставь где нужно оператор приведения типа:
short number = 9;
char zero = '0';
char nine = zero + number;
*/

public class Solution
{
    public static void main(String[] args)
    {
        short number = 9;
        char zero = '0';
        char nine = (char) (zero + number);
    }
}
