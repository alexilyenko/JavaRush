package com.javarush.test.level14.lesson08.home07;

import java.util.ArrayList;
import java.util.List;

/* Клининговый центр
Клининговый центр
1. Реализовать метод cleanAllApartaments.
Для каждого объекта из apartaments:
2. Для однокомнатных квартир (Apt1Room) вызвать метод clean1Room.
т.е. если объект типа Apt1Room, то вызвать у него метод clean1Room.
3. Для двухкомнатных квартир (Apt2Room) вызвать метод clean2Rooms
т.е. если объект типа Apt2Room, то вызвать у него метод clean2Rooms.
4. Для трехкомнатных квартир (Apt3Room) вызвать метод clean3Rooms
т.е. если объект типа Apt3Room, то вызвать у него метод clean3Rooms.
*/
class Solution {

  public static void main(String[] args) {
    List<Apartament> apartaments = new ArrayList<>();
    apartaments.add(new Apt1Room());
    apartaments.add(new Apt2Room());
    apartaments.add(new Apt3Room());

    cleanAllApartaments(apartaments);
  }

  private static void cleanAllApartaments(List<Apartament> apartaments) {
    for (Apartament a : apartaments) {
      if (a instanceof Apt1Room) {
        ((Apt1Room) a).clean1Room();
      } else if (a instanceof Apt2Room) {
        ((Apt2Room) a).clean2Rooms();
      } else if (a instanceof Apt3Room) {
        ((Apt3Room) a).clean3Rooms();
      }
    }

  }

  private interface Apartament {

  }

  static class Apt1Room implements Apartament {

    void clean1Room() {
      System.out.println("1 room is cleaned");
    }
  }

  static class Apt2Room implements Apartament {

    void clean2Rooms() {
      System.out.println("2 rooms are cleaned");
    }
  }

  static class Apt3Room implements Apartament {

    void clean3Rooms() {
      System.out.println("3 rooms are cleaned");
    }
  }
}
