package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

class Solution {

  public static void main(String[] args) {
    HashMap<String, Date> map = createMap();
    for (Map.Entry<String, Date> pair : map.entrySet()) {
      System.out.print(pair.getKey() + " ");
    }
    System.out.println("");
    removeAllSummerPeople(map);
    for (Map.Entry<String, Date> pair : map.entrySet()) {
      System.out.print(pair.getKey() + " ");
    }
  }

  @SuppressWarnings("deprecation")
  private static HashMap<String, Date> createMap() {
    HashMap<String, Date> map = new HashMap<>();
    map.put("Сталлоне", new Date("JUNE 1 1980"));
    map.put("БрюсЛи", new Date("APRIL 1 1970"));
    map.put("ДжеккиЧан", new Date("SEPTEMBER 1 1980"));
    map.put("Шварцнегер", new Date("AUGUST 1 1960"));
    map.put("ВанДам", new Date("JULY 1 1986"));
    map.put("ЧакНоррис", new Date("OCTOBER 1 1955"));
    map.put("Стэтхем", new Date("DECEMBER 1 1967"));
    map.put("БрюсУиллис", new Date("MAY 1 1954"));
    map.put("ДольфЛунгрен", new Date("NOVEMBER 1 1967"));
    map.put("СтивенСигал", new Date("DECEMBER 2 1980"));
    return map;
  }

  @SuppressWarnings("deprecation")
  private static void removeAllSummerPeople(HashMap<String, Date> map) {
    ArrayList<String> keys = new ArrayList<>();
    for (Map.Entry<String, Date> pair : map.entrySet()) {
      if (pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6
          || pair.getValue().getMonth() == 7) {
        keys.add(pair.getKey());
      }
    }
    for (String key : keys) {
      map.remove(key);
    }
  }

}
