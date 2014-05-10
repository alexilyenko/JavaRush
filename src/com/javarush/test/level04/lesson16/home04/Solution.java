package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
         Scanner scan = new Scanner(System.in);
         String name = scan.nextLine();
         int b1 = scan.nextInt();
         int b2 = scan.nextInt();
         int b3 = scan.nextInt();
         System.out.println("Меня зовут "+ name);
         System.out.println("Я родился "+b3+"."+b2+"."+b1);
    }
}
