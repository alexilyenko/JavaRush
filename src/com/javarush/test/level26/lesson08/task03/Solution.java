package com.javarush.test.level26.lesson08.task03;

/* Распределение элементов по корзинам с собственным локом.
В синхронизированных блоках используйте нужный лок.
*/
class Solution {

  private static final int NUMBER_LOCKS = 12;
  private final Node[] buckets;
  private final Object[] locks;

  public Solution(int numberBuckets) {
    buckets = new Node[numberBuckets];
    locks = new Object[NUMBER_LOCKS];
    for (int i = 0; i < NUMBER_LOCKS; i++) {
      locks[i] = new Object();
    }
  }

  private int hash(Object key) {
    return Math.abs(key.hashCode() % buckets.length);
  }

  public Object get(Object key) {
    int hash = hash(key);
    synchronized (locks[hash % NUMBER_LOCKS]) {
      for (Node m = buckets[hash]; m != null; m = m.next) {
        if (m.key.equals(key)) {
          return m.value;
        }
      }
    }
    return null;
  }

  public void clear() {
    for (int i = 0; i < buckets.length; i++) {
      synchronized (locks[i % NUMBER_LOCKS]) {
        buckets[i] = null;
      }
    }
  }

  private static class Node {

    Node next;
    Object key;
    Object value;
  }
}
