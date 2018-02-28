package com.javarush.test.level16.lesson05.task03;

/* Продвижение на политических дебатах
1. Разберитесь, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал, пока не завершится всё свободное время.
*/

class Solution {

  private static final int totalCountSpeeches = 200;
  private static final int soundsInOneSpeech = 1000000;

  public static void main(String[] args) throws InterruptedException {
    Politic ivanov = new Politic("Иванов");
    ivanov.join();
    Politic petrov = new Politic("Петров");
    Politic sidorov = new Politic("Сидоров");

    //noinspection StatementWithEmptyBody
    while (ivanov.getCountSpeaches() + petrov.getCountSpeaches() + sidorov.getCountSpeaches()
        < totalCountSpeeches) {
    }

    System.out.println(ivanov);
    System.out.println(petrov);
    System.out.println(sidorov);
  }

  static class Politic extends Thread {

    private int countSounds;

    Politic(String name) {
      super(name);
      start();
    }

    public void run() {
      while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
        countSounds++;
      }
    }

    int getCountSpeaches() {
      return countSounds / soundsInOneSpeech;
    }

    @Override
    public String toString() {
      return String.format("%s сказал речь %d раз", getName(), getCountSpeaches());
    }
  }
}
