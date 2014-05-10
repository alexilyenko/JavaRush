package com.javarush.test.level04.lesson13.task02;

import java.util.Scanner;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        for (int y=0; y<m; y++){
            for (int x=0; x<n; x++)
                System.out.print(8);
            System.out.println("");
        }

    }
}
