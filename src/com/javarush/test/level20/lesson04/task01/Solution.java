package com.javarush.test.level20.lesson04.task01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
@SuppressWarnings("WeakerAccess")
class Solution {

  static class Human implements Serializable {

    final List<Asset> assets = new ArrayList<>();
    String name;

    public Human() {
    }

    public Human(String name, Asset... assets) {
      this.name = name;
      if (assets != null) {
        this.assets.addAll(Arrays.asList(assets));
      }
    }
  }
}
