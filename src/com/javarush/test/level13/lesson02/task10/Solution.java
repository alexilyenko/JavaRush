package com.javarush.test.level13.lesson02.task10;

/* CleverMan и SmartGirl
1. Добавь интерфейсы Secretary и Boss к классам CleverMan и SmartGirl. По одному на каждый. Подумай, кому какой.
2. Унаследуй  интерфейсы Secretary и Boss от интерфейсов Person и Workable так,
чтобы все методы у классов CleverMan и SmartGirl оказались объявленными в каком-то интерфейсе.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface Person
    {
        void use(Person person);
        void startToWork();
    }

    interface Workable
    {
        boolean wantGetExtraWork();
    }

    interface Secretary extends Person
    {
    }

    interface Boss extends Person, Workable
    {
    }

    class CleverMan implements Boss
    {
        public void use(Person person)
        {
            person.startToWork();
        }

        public void startToWork()
        {
        }

        public boolean wantGetExtraWork()
        {
            return true;
        }
    }

    class SmartGirl implements Secretary
    {
        public void use(Person person)
        {
        }

        public void startToWork()
        {
        }
    }
}
