package com.javarush.test.level24.lesson06.home01;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {

  private final String name;

  public Cat(String name) {
    this.name = name;
  }

  /**
   * @param i количество букв 'я' в слове мяу
   * @return экземпляр класса CatPet
   **/
  public Sayable toSayable(final int i) {
    class CatPet implements Sayable {

      @Override
      public String say() {
        if (i <= 0) {
          return name + " спит.";
        } else {
          StringBuilder stringBuilder = new StringBuilder(name + " говорит м");
          for (int j = 0; j < i; j++) {
            stringBuilder.append("я");
          }
          return stringBuilder.append("у!").toString();
        }
      }
    }
    return new CatPet();
  }
}