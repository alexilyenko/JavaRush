package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

class Solution {

  public static void main(String[] args) {
    Human ded1 = new Human("Vasya", true, 60);
    Human babka1 = new Human("Masha", false, 55);
    Human ded2 = new Human("Vitya", true, 63);
    Human babka2 = new Human("Katya", true, 53);
    Human papa = new Human("Lesha", true, 30, ded1, babka1);
    Human mama = new Human("Lyuba", false, 25, ded2, babka2);
    Human syn1 = new Human("Pasha", true, 10, papa, mama);
    Human syn2 = new Human("Kostya", true, 5, papa, mama);
    Human dochka = new Human("Sofiya", false, 2, papa, mama);

    System.out.println(ded1.toString());
    System.out.println(babka1.toString());
    System.out.println(ded2.toString());
    System.out.println(babka2.toString());
    System.out.println(papa.toString());
    System.out.println(mama.toString());
    System.out.println(syn1.toString());
    System.out.println(syn2.toString());
    System.out.println(dochka.toString());
  }

  static class Human {

    private final String name;
    private final boolean sex;
    private final int age;
    private Human father;
    private Human mother;

    Human(String name, boolean sex, int age) {
      this.name = name;
      this.sex = sex;
      this.age = age;
    }

    Human(String name, boolean sex, int age, Human father, Human mother) {
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.father = father;
      this.mother = mother;
    }

    public String toString() {
      String text = "";
      text += "Имя: " + this.name;
      text += ", пол: " + (this.sex ? "мужской" : "женский");
      text += ", возраст: " + this.age;

      if (this.father != null) {
        text += ", отец: " + this.father.name;
      }

      if (this.mother != null) {
        text += ", мать: " + this.mother.name;
      }

      return text;
    }
  }
}
