package com.javarush.test.level24.lesson04.task01;

import java.math.BigDecimal;

/* Наследование от внутреннего класса
Внутри класса Solution создайте 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуйте их от Apartments и Hall.
*/
class Solution {

  class Building {

    class Hall {

      private final BigDecimal square;

      Hall(BigDecimal square) {
        this.square = square;
      }
    }

    class Apartments {

    }

  }

  private class Apt3Bedroom extends Building.Apartments {

    Apt3Bedroom(Building building) {
      building.super();
    }
  }

  private class BigHall extends Building.Hall {

    BigHall(Building building, BigDecimal square) {
      building.super(square);
    }
  }

}
