package com.javarush.test.level04.lesson13.task01;

/* Четные числа
Используя цикл for вывести на экран чётные числа от 1 до 100 включительно.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for (int x=2;x<=100;x=x+2)
            System.out.print(x+" ");
    }
}
