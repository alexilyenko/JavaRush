package com.javarush.test.level04.lesson13.task05;

import java.util.Scanner;

/* Все любят Мамбу
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: [*имя* любит меня.]
Пример текста:
Света любит меня.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for(int x=0; x<10; x++)
            System.out.println(name+" любит меня.");
    }
}
