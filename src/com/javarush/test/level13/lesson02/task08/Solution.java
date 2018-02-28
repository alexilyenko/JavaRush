package com.javarush.test.level13.lesson02.task08;

/* Жив или нет
1. Создай интерфейс Person.
2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
3. Подумай, какой тип должен возвращать этот метод.
4. Создай интерфейс Presidentable.
5. Унаследуй интерфейс Presidentable от интерфейса Person.
*/

class Solution {

  private interface Person {

    boolean isAlive();
  }

  public interface Presidentable extends Person {

  }
}
