package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<Thread> threads = new ArrayList<>(5);

  static {
    threads.add(new Thread1());
    threads.add(new Thread2());
    threads.add(new Thread3());
    threads.add(new Thread4());
    threads.add(new Thread5());
  }

  static class Thread1 extends Thread {

    @SuppressWarnings("StatementWithEmptyBody")
    public void run() {
      //noinspection InfiniteLoopStatement
      while (true) {
      }
    }
  }

  static class Thread2 extends Thread {

    @SuppressWarnings("StatementWithEmptyBody")
    public void run() {
      try {
        //noinspection InfiniteLoopStatement
        while (!isInterrupted()) {

        }
        throw new InterruptedException();
      } catch (InterruptedException e) {
        System.out.println("InterruptedException");
      }
    }
  }

  static class Thread3 extends Thread {

    public void run() {
      //noinspection InfiniteLoopStatement
      while (true) {
        try {
          System.out.println("Ура");
          Thread.sleep(500);
        } catch (InterruptedException ignore) {/*NOP*/}
      }
    }
  }

  public static class Thread4 extends Thread implements Message {

    public void showWarning() {
      this.interrupt();
      try {
        this.join();
      } catch (InterruptedException ignore) {/*NOP*/}
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void run() {
      Thread current = currentThread();
      while (!current.isInterrupted()) {
      }
    }
  }

  static class Thread5 extends Thread {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int sum;
    private String a;

    public void run() {
      while (!isInterrupted()) {
        try {
          if ((a = reader.readLine()).equals("N")) {
            System.out.println(sum);
            this.interrupt();
            continue;
          }
          sum = sum + Integer.parseInt(a);
        } catch (IOException ignore) {/*NOP*/}
      }
    }
  }
}
