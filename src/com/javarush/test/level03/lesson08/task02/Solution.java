package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        System.out.println(name+" получает "+num1+" через "+num2+" лет.");
    }
}