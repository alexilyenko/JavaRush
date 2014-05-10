package com.javarush.test.level07.lesson12.home07;

/* Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.
*/

public class Solution
{
    public static int A = 5;
    public static int B = 2;
    public static int C = A*B;

    public static void main(String[] args)
    {
    }

    public int getValue()
    {
        return C;
    }

}

