package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

class Solution {

  @SuppressWarnings("SuspiciousMethodCalls")
  public static void main(String[] args) {
    Set<Cat> cats = createCats();

    Iterator iterator = cats.iterator();
    //noinspection SuspiciousMethodCalls
    cats.remove(iterator.next());
    printCats(cats);
  }

  private static Set<Cat> createCats() {
    Set<Cat> cats = new HashSet<>();  //создал множество
    Cat cat = new Cat();  //создал объекты-котов
    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    cats.add(cat); // добавил объекты в множество
    cats.add(cat1);
    cats.add(cat2);
    return cats;
  }

  private static void printCats(Set<Cat> cats) {
    for (Cat p : cats) {
      System.out.println(p);
    }
  }

  static class Cat  // ничего не добавлял тут внутри, поскольку сами свойства класса не упоминаются в условии задачи, только "кот" как сам объект
  {

  }
}
