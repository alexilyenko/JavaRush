package com.javarush.test.level10.lesson04.task05;

/* Задача №5 на преобразование целых типов
Расставь где нужно оператор приведения типа:
short number = 9;
char zero = '0';
short nineCode = zero + number;
*/

public class Solution
{
    public static void main(String[] args)
    {
        short number = 9;
        char zero = '0';
        short nineCode = (short)(zero + number);
    }
}