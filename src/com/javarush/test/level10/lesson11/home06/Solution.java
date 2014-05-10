package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
       private String name;
       private int age;
       private boolean sex;
       private String lastName;
       private int weight;
       private int height;

       public Human(String name) {
           name = this.name;
       }

        public Human(String name, int age) {
            name = this.name;
            age = this.age;
        }

        public Human (String name, int age, boolean sex, String lastName, int weight, int height) {
            name = this.name;
            age = this.age;
            sex = this.sex;
            lastName = this.lastName;
            weight = this.weight;
            height = this.height;
        }

        public Human (String name, int age, boolean sex, String lastName, int weight) {
            name = this.name;
            age = this.age;
            sex = this.sex;
            lastName = this.lastName;
            weight = this.weight;
        }

        public Human (String name, int age, boolean sex, String lastName) {
            name = this.name;
            age = this.age;
            sex = this.sex;
            lastName = this.lastName;
        }

        public Human (String name, int age, boolean sex) {
            name = this.name;
            age = this.age;
            sex = this.sex;
        }

        public Human (String name, boolean sex) {
            name = this.name;
            sex = this.sex;
        }

        public Human (String name, String lastName, int weight) {
            name = this.name;
            weight = this.weight;
            lastName = this.lastName;
        }

        public Human (String name, String lastName) {
            name = this.name;
            lastName = this.lastName;
        }

        public Human (String name, String lastName, int height, int weight) {
            name = this.name;
            lastName = this.lastName;
            weight = this.weight;
            height = this.height;
        }


    }
}
