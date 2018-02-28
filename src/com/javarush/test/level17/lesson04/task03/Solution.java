package com.javarush.test.level17.lesson04.task03;

import java.util.ArrayList;
import java.util.List;

/* Сад-огород
1. Создайте метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index
2. Создайте метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index
3. Создайте метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index
4. Создайте метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index
5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мютекс this
6. Реализуй это минимальным количеством кода
*/

class Solution {

  static class Garden {

    final List<String> fruits = new ArrayList<>();
    final List<String> vegetables = new ArrayList<>();


    public synchronized void addFruit(int index, String fruit) {
      fruits.add(index, fruit);
    }

    public synchronized void removeFruit(int index) {
      fruits.remove(index);
    }

    public synchronized void addVegetable(int index, String vegetable) {
      vegetables.add(index, vegetable);
    }

    public synchronized void removeVegetable(int index) {
      vegetables.remove(index);
    }

  }
}
