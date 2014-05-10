package com.javarush.test.level17.lesson10.home06;

/* Глажка
И снова быт...
Поставьте один synchronized, чтобы diana и igor гладили по-очереди, ведь утюг всего один!
*/

public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            Iron iron = takeIron();
            Clothes clothes = takeClothes();
            ironing(iron, clothes);
            returnIron();
        }

        protected Iron takeIron() {
            System.out.println("Taking an Iron");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Returning the Iron");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected synchronized void ironing(Iron iron, Clothes clothes) {
            System.out.println(getName() + "'s ironing the " + clothes.name);
        }
    }

    public static class Iron {
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}
