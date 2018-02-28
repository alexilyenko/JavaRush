package com.javarush.test.level15.lesson12.home04;

/* Закрепляем Singleton pattern
1. Найти в гугле пример для - Singleton pattern Lazy initialization.
2. По образу и подобию в отдельных файлах создать три синглтон класса Sun, Moon, Earth.
3. Реализовать интерфейс Planet для классов Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet.
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считать один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, то создать соответствующий объект и присвоить его Planet thePlanet, иначе обнулить Planet thePlanet.
5.3. Сравнивать введенный параметр можно только с константами из Planet, нельзя создавать свои строки.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  @SuppressWarnings("FieldCanBeLocal")
  private static Planet thePlanet;

  static {
    readKeyFromConsoleAndInitPlanet();
  }

  //add static block here - добавьте статический блок тут

  private static void readKeyFromConsoleAndInitPlanet() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      String input = reader.readLine();
      switch (input) {
        case Planet.SUN:
          thePlanet = Sun.getInstance();
          break;
        case Planet.MOON:
          thePlanet = Moon.getInstance();
          break;
        case Planet.EARTH:
          thePlanet = Earth.getInstance();
          break;
      }
    } catch (IOException ignored) {
    }
  }
}
