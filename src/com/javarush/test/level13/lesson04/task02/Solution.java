package com.javarush.test.level13.lesson04.task02;

/* Исправление кода
Исправить код так, чтобы программа выполнялась и выводила "Я переводчик с английского".
Метод main менять нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Translator translator = new Translator();
        System.out.println(translator.translate());
    }

    public static class Translator
    {
        public String translate()
        {
            return "Я переводчик с английского";
        }
    }


}
