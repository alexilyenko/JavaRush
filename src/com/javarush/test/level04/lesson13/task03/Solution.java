package com.javarush.test.level04.lesson13.task03;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int y, x;
        for (y=1;y<=10;y++){
            for (x=0; x<y; x++)
                System.out.print(8);
            System.out.println("");
        }
    }
}
