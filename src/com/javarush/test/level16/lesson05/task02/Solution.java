package com.javarush.test.level16.lesson05.task02;

import java.util.ArrayList;
import java.util.List;

/* Horse Racing
Разберись, что делает программа.
Реализуй метод calculateHorsesFinished. Он должен:
1. Посчитать количество финишировавших лошадей и возвратить его. Используй метод isFinished().
2. Если лошадь еще не пришла к финишу (!isFinished()), то:
2.1. Вывести в консоль "Waiting for " + horse.getName().
2.2. Подождать, пока она завершит гонку. Подумай, какой метод нужно использовать для этого.
*/

class Solution {

  private static final int countHorses = 10;

  @SuppressWarnings("StatementWithEmptyBody")
  public static void main(String[] args) throws InterruptedException {
    List<Horse> horses = prepareHorsesAndStart();
    while (calculateHorsesFinished(horses) != countHorses) {
    }
  }

  private static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
    int countFinished = 0;
    for (Horse horse : horses) {
      if (horse.isFinished()) {
        countFinished++;
      } else {
        System.out.println("Waiting for " + horse.getName());
        horse.join();
        if (horse.isFinished()) {
          countFinished++;
        }

      }
    }
    return countFinished;
  }

  private static List<Horse> prepareHorsesAndStart() {
    List<Horse> horses = new ArrayList<>(countHorses);
    String number;
    for (int i = 1; i < countHorses + 1; i++) {
      number = i < 10 ? ("0" + i) : "" + i;
      horses.add(new Horse("Horse_" + number));
    }

    for (int i = 0; i < countHorses; i++) {
      horses.get(i).start();
    }
    return horses;
  }

  static class Horse extends Thread {

    private boolean isFinished;

    Horse(String name) {
      super(name);
    }

    boolean isFinished() {
      return isFinished;
    }

    public void run() {
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < 1001; i++) {   //delay
        s.append("").append(i);
        if (i == 1000) {
          s = new StringBuilder(" is finished!");
          System.out.println(getName() + s);
          isFinished = true;
        }
      }
    }
  }
}
