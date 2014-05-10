package com.javarush.test.level04.lesson10.task05;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while. Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int x=0;
        int y=1;
        while (x<10) {
            System.out.print(y+" ");
            y++;
            x++;
        }

        System.out.println("");
        y=2;
        while (x<20) {
            System.out.print(y+" ");
            y=y+2;
            x++;
        }

        System.out.println("");
        y=3;
        while (x<30) {
            System.out.print(y+" ");
            y=y+3;
            x++;
        }

        System.out.println("");
        y=4;
        while (x<40) {
            System.out.print(y+" ");
            y=y+4;
            x++;
        }

        System.out.println("");
        y=5;
        while (x<50) {
            System.out.print(y+" ");
            y=y+5;
            x++;
        }

        System.out.println("");
        y=6;
        while (x<60) {
            System.out.print(y+" ");
            y=y+6;
            x++;
        }

        System.out.println("");
        y=7;
        while (x<70) {
            System.out.print(y+" ");
            y=y+7;
            x++;
        }

        System.out.println("");
        y=8;
        while (x<80) {
            System.out.print(y+" ");
            y=y+8;
            x++;
        }

        System.out.println("");
        y=9;
        while (x<90) {
            System.out.print(y+" ");
            y=y+9;
            x++;
        }

        System.out.println("");
        y=10;
        while (x<100) {
            System.out.print(y+" ");
            y=y+10;
            x++;
        }

        System.out.println("");
    }
}
