package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

class Solution {

  public static void main(String[] args) {
    ArrayList<Human> zChildren = new ArrayList<>();
    Human child1 = new Human("Вася", true, 10, zChildren);
    Human child2 = new Human("Петя", true, 8, zChildren);
    Human child3 = new Human("Маша", false, 6, zChildren);
    ArrayList<Human> xChildren = new ArrayList<>();
    xChildren.add(child1);
    xChildren.add(child2);
    xChildren.add(child3);
    Human father = new Human("Михаил", true, 30, xChildren);
    Human mother = new Human("Раиса", false, 28, xChildren);
    ArrayList<Human> yChildren1 = new ArrayList<>();
    ArrayList<Human> yChildren2 = new ArrayList<>();
    yChildren1.add(father);
    yChildren2.add(mother);
    Human grandFather1 = new Human("Виктор", true, 60, yChildren1);
    Human grandMother1 = new Human("Евгения", false, 57, yChildren1);
    Human grandFather2 = new Human("Геннадий", true, 56, yChildren2);
    Human grandMother2 = new Human("Наталия", false, 54, yChildren2);

    System.out.println(grandFather1.toString());
    System.out.println(grandMother1.toString());
    System.out.println(grandFather2.toString());
    System.out.println(grandMother2.toString());
    System.out.println(father.toString());
    System.out.println(mother.toString());
    System.out.println(child1.toString());
    System.out.println(child2.toString());
    System.out.println(child3.toString());

  }

  static class Human {

    private final String name;
    private final boolean sex;
    private final int age;
    private final ArrayList<Human> children;

    Human(String name, boolean sex, int age, ArrayList<Human> children) {
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.children = children;
    }


    public String toString() {
      StringBuilder text = new StringBuilder();
      text.append("Имя: ").append(this.name);
      text.append(", пол: ").append(this.sex ? "мужской" : "женский");
      text.append(", возраст: ").append(this.age);

      int childCount = this.children.size();
      if (childCount > 0) {
        text.append(", дети: ").append(this.children.get(0).name);
        for (int i = 1; i < childCount; i++) {
          Human child = this.children.get(i);
          text.append(", ").append(child.name);
        }
      }
      return text.toString();
    }
  }
}
