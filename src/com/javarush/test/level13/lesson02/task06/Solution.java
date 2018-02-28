package com.javarush.test.level13.lesson02.task06;

/* Баг в initializeIdAndName
1. Подумать, что в программе неправильно.
2. Вынести реализацию метода initializeIdAndName в класс User.
3. initializeIdAndName в классе User должен возвращать тип User.
4. Поправить программу, чтобы компилировалась и работала.
*/

public class Solution {

  public static void main(String[] args) {
    System.out.println(Matrix.NEO);
    System.out.println(Matrix.TRINITY);
  }

  interface DBObject {

    DBObject initializeIdAndName(long id, String name);
  }

  static class Matrix {

    static final DBObject NEO = new User().initializeIdAndName(1, "Neo");
    static final DBObject TRINITY = new User().initializeIdAndName(2, "Trinity");
  }

  static class User implements DBObject {

    long id;
    String name;

    public User initializeIdAndName(long id, String name) {
      this.id = id;
      this.name = name;
      return this;
    }

    @Override
    public String toString() {
      return String.format("User has name %s, id = %d", name, id);
    }
  }

}
