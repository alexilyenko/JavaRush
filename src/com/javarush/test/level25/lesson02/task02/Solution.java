package com.javarush.test.level25.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {

  public enum Wheel {
    FRONT_LEFT,
    FRONT_RIGHT,
    BACK_LEFT,
    BACK_RIGHT
  }

  static class Car {

    final List<Wheel> wheels;

    public Car() {
      wheels = new ArrayList<>();
      for (String currentWheel : loadWheelNamesFromDB()) {
        wheels.add(Wheel.valueOf(currentWheel));
      }
    }

    String[] loadWheelNamesFromDB() {
      //this method returns mock data
      return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
    }
  }
}
