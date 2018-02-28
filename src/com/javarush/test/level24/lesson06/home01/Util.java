package com.javarush.test.level24.lesson06.home01;

import java.util.LinkedList;
import java.util.List;

class Util {

  //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
  public static void printDialog(List<Sayable> pets) {
    for (Sayable pet : pets) {
      System.out.println(pet.say());
    }
  }

  public static List<Pet> getPets() {
    List<Pet> pets = new LinkedList<>();
    pets.add(new Cat("Мурзик"));
    pets.add(new Cat("Васька"));
    pets.add(new Cat("Кошка"));
    pets.add(new Mouse());
    pets.add(new Cat("Томас"));
    return pets;
  }

  public static List<Sayable> convertPetToSayable(List<Pet> pets) {
    List<Sayable> result = new LinkedList<>();
    for (Pet pet : pets) {
      int i = (int) (Math.random() * 7) - 2;
      result.add(pet.toSayable(i));
    }
    return result;
  }
}
