package com.javarush.test.level13.lesson02.task09;

/* Наследование интерфейса
1. Создать интерфейс Movable с методом speed.
2. Метод speed возвращает значение типа Double и не принимает параметров.
3. Создать и унаследовать интерфейс Runable от интерфейса Movable.
4. Добавить в интерфейс Runable метод speed.
5. Метод speed возвращает значение типа Double и принимает один параметр типа Runable.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }
    public interface Movable {
        Double speed();
    }
    public interface Runable extends Movable {
        Double speed(Runable o);
    }
}
