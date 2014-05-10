package com.javarush.test.level19.lesson10.home03;

import java.util.Date;

public class Person {
    private String name;
    private Date birthday;

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String toString() {return this.getName()+" "+this.getBirthday();}
}
