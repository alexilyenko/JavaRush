package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by ailenko on 14.04.2014.
 */
public class Plane implements Flyable
{
    private int passengers;

    public Plane(int passengers) {
        this.passengers = passengers;
    }
    public void fly() {}
}
