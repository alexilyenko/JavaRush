package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

class Consumer implements Runnable {

  private final ConcurrentHashMap<String, String> map;

  Consumer(ConcurrentHashMap<String, String> map) {
    this.map = map;
  }

  public void run() {
    Thread currentThread = Thread.currentThread();
    while (!currentThread.isInterrupted()) {
      if (!map.isEmpty()) {
        for (String key : map.keySet()) {
          System.out.println(map.remove(key));
        }
      }
    }
  }
}