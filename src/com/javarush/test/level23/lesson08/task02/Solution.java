package com.javarush.test.level23.lesson08.task02;

/* Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution.
Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 sec
*/
class Solution {

  private final String name;
  private final String food;
  private final String sound;

  private Solution(String name, String food, String sound) {
    this.name = name;
    this.food = food;
    this.sound = sound;
  }

  public static void main(String[] args) throws InterruptedException {
    new Solution("Amigo", "beef", "knock").live();
  }

  private void eat() {
    System.out.println(name + ": Mmmmm, " + food);
  }

  private void play() {
    System.out.println(name + ": " + sound + " " + sound);
  }

  private void sleep(long milliseconds) {
    System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " sec");
  }

  private void live() throws InterruptedException {
    Thread thread = new Thread() {
      public void run() {
        try {
          someActions();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      private void someActions() {
        eat();
        play();
        Solution.this.sleep(1000);
      }
    };
    thread.start();
    thread.join();
  }
}
