package com.javarush.test.level20.lesson07.task03;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
class Solution implements Serializable {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Person person = new Person("Bart", "Simpson", 25);
    Person mom = new Person("Marge", "Simpson", 53);
    Person dad = new Person("Homer", "Simpson", 59);
    Person child1 = new Person("LittleBoy", "Simpson", 8);
    Person child2 = new Person("LittleGirl", "Simpson", 3);
    person.setFather(dad);
    person.setMother(mom);
    List<Person> list = new ArrayList<>();
    list.add(child1);
    list.add(child2);
    person.setChildren(list);

    System.out.println(
        person.firstName + " " + person.lastName + " " + person.age + " " + person.father.firstName
            + " " + person.mother.firstName + " " + person.children);

    File file = new File("d:/1.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(person);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
    Person newPerson = (Person) ois.readObject();
    ois.close();

    System.out.println(newPerson.firstName + " " + newPerson.lastName + " " + newPerson.age + " "
        + newPerson.father.firstName + " " + newPerson.mother.firstName + " " + newPerson.children);
  }

  static class Person implements Externalizable {

    private String firstName;
    private String lastName;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person() {
    }

    Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
    }

    void setMother(Person mother) {
      this.mother = mother;
    }

    void setFather(Person father) {
      this.father = father;
    }

    void setChildren(List<Person> children) {
      this.children = children;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeObject(this.mother);
      out.writeObject(this.father);
      out.writeObject(this.firstName);
      out.writeObject(this.lastName);
      out.writeInt(this.age);
      out.writeObject(this.children);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      mother = (Person) in.readObject();
      father = (Person) in.readObject();
      firstName = (String) in.readObject();
      lastName = (String) in.readObject();
      age = in.readInt();
      children = (List<Person>) in.readObject();
    }
  }
}
