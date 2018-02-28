package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

class Solution {

  public static void main(String[] args) {
    Man man1 = new Man("Alex", 24, "Ussuriyska");
    Man man2 = new Man("Eugene", 25, "Chernihivkska");
    Woman woman1 = new Woman("Oksana", 20, "Ussuriyska");
    Woman woman2 = new Woman("Ira", 22, "Vyborzka");

    man1.getOutPut();
    man2.getOutPut();
    woman1.getOutPut();
    woman2.getOutPut();
  }

  static class Man {

    private final String name;
    private final int age;
    private final String address;

    Man(String name, int age, String address) {
      this.name = name;
      this.age = age;
      this.address = address;
    }

    void getOutPut() {
      System.out.println(name + " " + age + " " + address);
    }
  }

  static class Woman {

    private final String name;
    private final int age;
    private final String address;

    Woman(String name, int age, String address) {
      this.name = name;
      this.age = age;
      this.address = address;
    }

    void getOutPut() {
      System.out.println(name + " " + age + " " + address);
    }
  }
}
