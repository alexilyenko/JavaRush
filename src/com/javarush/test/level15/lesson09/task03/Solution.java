package com.javarush.test.level15.lesson09.task03;

/* Статики 3
1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
intVar с типом int
doubleVar с типом double
DoubleVar с типом Double
booleanVar с типом boolean
ObjectVar с типом Object
ExceptionVar с типом Exception
StringVar с типом String
2. В методе main вывести их значения в заданном порядке.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(intVar);
        System.out.println(doubleVar);
        System.out.println(DoubleVar);
        System.out.println(booleanVar);
        System.out.println(ObjectVar);
        System.out.println(ExceptionVar);
        System.out.println(StringVar);
    }

    public static int intVar;
    public static double doubleVar;
    public static Double DoubleVar;
    public static boolean booleanVar;
    public static Object ObjectVar;
    public static Exception ExceptionVar;
    public static String StringVar;
}
