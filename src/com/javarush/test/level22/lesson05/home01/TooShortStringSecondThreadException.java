package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(StringIndexOutOfBoundsException e)
    {
    }
}
