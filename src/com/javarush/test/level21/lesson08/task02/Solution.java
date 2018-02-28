package com.javarush.test.level21.lesson08.task02;

import java.util.Arrays;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {

  public static void main(String[] args) {
    Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
    Tree clone = null;
    try {
      clone = tree.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    System.out.println(tree);
    System.out.println(clone);

    System.out.println(Arrays.toString(tree.branches));
    //noinspection ConstantConditions
    System.out.println(Arrays.toString(clone.branches));
  }

  protected static class Plant {

    private final String name;

    Plant(String name) {
      this.name = name;
    }

    String getName() {
      return name;
    }

    @Override
    protected Plant clone() throws CloneNotSupportedException {
      Plant plant = (Plant) super.clone();
      return new Plant(this.getName());
    }
  }

  protected static class Tree extends Plant {

    private final String[] branches;

    Tree(String name, String[] branches) {
      super(name);
      this.branches = branches;
    }

    String[] getBranches() {
      return branches;
    }

    @Override
    protected Tree clone() throws CloneNotSupportedException {
      Tree tree = (Tree) super.clone();
      if (this.getBranches() != null) {
        return new Tree(this.getName(), this.getBranches().clone());
      } else {
        return new Tree(this.getName(), null);
      }
    }
  }
}
