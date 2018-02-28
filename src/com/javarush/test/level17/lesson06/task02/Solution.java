package com.javarush.test.level17.lesson06.task02;

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым.
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private static volatile int proposal = 0;

  public static void main(String[] args) {
    new MakeProposal().start();
    new AcceptProposal().start();
  }

  static class MakeProposal extends Thread {

    @Override
    public void run() {
      int thisProposal = proposal;

      while (proposal < 10) {
        System.out.println("Сделано предложение №" + (thisProposal + 1));
        proposal = ++thisProposal;
        try {
          TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class AcceptProposal extends Thread {

    @Override
    public void run() {
      int thisProposal = proposal;

      while (thisProposal < 10) {
        if (thisProposal != proposal) {
          System.out.println("Принято предложение №" + proposal);
          thisProposal = proposal;
        }
      }
    }
  }
}
