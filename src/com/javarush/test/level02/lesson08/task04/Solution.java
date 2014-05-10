package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Использовать функцию из задачи 1.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        int mainMin;
        int m2 = min(a,b);
        int m3 = min(c,d);
        if (m2<m3)
            mainMin = m2;
        else
            mainMin = m3;
        return mainMin;
    }

    public static int min(int a, int b)
    {
        int m1;
        if (a<b)
            m1=a;
        else
            m1=b;
        return m1;

     }
}