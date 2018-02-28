package com.javarush.test.level20.lesson04.task03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Как сериализовать Singleton?
Два десериализованных объекта singleton и singleton1 имеют разные ссылки в памяти, а должны иметь одинаковые.
В класс Singleton добавьте один метод (погуглите), чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.
*/
class Solution implements Serializable {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Singleton instance = Singleton.getInstance();

    //Serializing the singleton instance
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.tmp"));
    oos.writeObject(instance);
    oos.close();

    //Recreating the instance by reading the serialized object data store
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.tmp"));
    Singleton singleton = (Singleton) ois.readObject();
    ois.close();

    //Recreating the instance AGAIN by reading the serialized object data store
    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("singleton.tmp"));
    Singleton singleton1 = (Singleton) ois2.readObject();
    ois2.close();

    //The singleton behavior have been broken
    System.out.println("Instance reference check : " + Singleton.getInstance());
    System.out.println("Instance reference check : " + Singleton.getInstance());
    System.out.println("=========================================================");
    System.out.println("Object reference check : " + singleton);
    System.out.println("Object reference check : " + singleton1);
  }

  static class Singleton implements Serializable {

    private static Singleton ourInstance;

    private Singleton() {
    }

    static Singleton getInstance() {
      if (ourInstance == null) {
        ourInstance = new Singleton();
      }
      return ourInstance;
    }

    private Object readResolve() {
      return ourInstance;
    }
  }
}
