package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

class Solution {

  public static void main(String[] args) {
    Set<Cat> cats = createCats();
    Set<Dog> dogs = createDogs();
    Set<Object> pets = join(cats, dogs);
    printPets(pets);
    removeCats(pets, cats);
    printPets(pets);
  }

  private static Set<Cat> createCats() {
    HashSet<Cat> resultCat = new HashSet<>();
    for (int i = 0; i < 4; i++) {
      resultCat.add(new Cat());
    }
    return resultCat;
  }

  private static Set<Dog> createDogs() {
    HashSet<Dog> resultDog = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      resultDog.add(new Dog());
    }
    return resultDog;
  }

  private static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
    Set<Object> pets = new HashSet<>();
    pets.addAll(cats);

    pets.addAll(dogs);

    return pets;
  }

  private static void removeCats(Set<Object> pets, Set<Cat> cats) {
    Set<Object> catsForDelete = new HashSet<>();
    for (Object animal : pets) {
      for (Cat kot : cats) {
        if (animal.equals(kot)) {
          catsForDelete.add(animal);
        }
      }

    }
    for (Object o : catsForDelete) {
      pets.remove(o);
    }
  }

  private static void printPets(Set<Object> pets) {
    for (Object p : pets) {
      System.out.println(p);
    }
  }

  static class Cat {

  }

  static class Dog {

  }
}
