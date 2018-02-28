package com.javarush.test.level13.lesson11.home05;

/* Neo
1. Реализовать интерфейс DBObject в классе User.
2. Реализовать метод initializeIdAndName так, чтобы программа работала и выводила на экран "User has name Neo, id = 1".
3. Метод toString и метод main менять нельзя.
4. Подумай, что должен возвращать метод initializeIdAndName в классе User.
*/

public class Solution {

  public static void main(String[] args) {
    System.out.println(Matrix.NEO);
  }


  interface DBObject {

    DBObject initializeIdAndName(long id, String name);
  }

  static class Matrix {

    static final DBObject NEO = new User().initializeIdAndName(1, "Neo");
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
