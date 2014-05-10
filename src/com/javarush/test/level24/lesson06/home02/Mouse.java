package com.javarush.test.level24.lesson06.home02;

/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мыша пищит.";
    }
}
