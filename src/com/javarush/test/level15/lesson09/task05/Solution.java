package com.javarush.test.level15.lesson09.task05;

/* Статики 4
Внутри статического блока:
1. создайте класс Cat
2. Внутри Cat создайте поле класса String name = "Пушок"
3. создайте объект класса Cat
4. присвойте статическому объекту Object cat созданный вами
5. Выведите в консоль myCat.name
*/

class Solution {

  private static final Object cat;

  static {
    class Cat {

      private final String name = "Пушок";
    }
    cat = new Cat();
    Cat myCat = (Cat) cat;
    System.out.println(myCat.name);
  }

}
