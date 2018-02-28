package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution {

  private final Map<String, User> users = new LinkedHashMap<>();

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.users.put("Hubert", new User(172, "Hubert"));
    solution.users.put("Zapp", new User(41, "Zapp"));
    Solution clone;
    try {
      clone = solution.clone();
      System.out.println(solution);
      System.out.println(clone);

      System.out.println(solution.users);
      System.out.println(clone.users);

    } catch (CloneNotSupportedException e) {
      e.printStackTrace(System.err);
    }
  }

  @Override
  protected Solution clone() throws CloneNotSupportedException {
    Solution solution1 = (Solution) super.clone();
    Map<String, User> users = new LinkedHashMap<>();
    for (Map.Entry<String, User> entry : this.users.entrySet()) {
      User user = entry.getValue().clone();
      users.put(entry.getKey(), user);
    }
    Solution solution = new Solution();
    solution.users.putAll(users);
    return solution;
  }

  protected static class User {

    final int age;
    final String name;

    User(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
      User user = (User) super.clone();
      return new User(this.age, this.name);
    }
  }
}
