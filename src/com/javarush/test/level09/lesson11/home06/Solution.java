package com.javarush.test.level09.lesson11.home06;

import java.util.ArrayList;

/* Сказка «Красная Шапочка»
1. Есть пять классов: красная шапочка, бабушка, пирожок, дровосек, волк.
2. У каждого класса есть 2 поля: убил (killed ArrayList) и съел (ate ArrayList).
3. Необходимые объекты созданы (hood, grandmother, ...).
4. Расставь правильно связи, кто кого съел и убил, чтобы получилась логика сказки «Красная Шапочка».
PS: пирожки никто не ел. Их только несли. Волк чуток поел. А его потом убили.
*/

public class Solution {

  private static final LittleRedRidingHood hood = new LittleRedRidingHood();
  private static final Grandmother grandmother = new Grandmother();
  private static final Woodman woodman = new Woodman();
  private static final Wolf wolf = new Wolf();
  public static Patty patty = new Patty();

  public static void main(String[] args) {
    wolf.ate.add(grandmother);
    wolf.ate.add(hood);
    woodman.killed.add(wolf);
  }

  //красная шапочка
  private static class LittleRedRidingHood extends StoryItem {

  }

  //бабушка
  private static class Grandmother extends StoryItem {

  }

  //пирожок
  private static class Patty extends StoryItem {

  }

  //дровосек
  private static class Woodman extends StoryItem {

  }

  //волк
  private static class Wolf extends StoryItem {

  }

  static abstract class StoryItem {

    final ArrayList<StoryItem> killed = new ArrayList<>();
    final ArrayList<StoryItem> ate = new ArrayList<>();
  }
}
