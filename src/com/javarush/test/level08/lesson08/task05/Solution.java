package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

class Solution {

  @SuppressWarnings("Duplicates")
  public static HashMap<String, String> createMap() {
    Map<String, String> map = new HashMap<>();
    map.put("Ivanov", "Ivan");
    map.put("Petrov", "Petr");
    map.put("Herov", "Her");
    map.put("Dul'kin", "Dula");
    map.put("Petin", "Afanasiy");
    map.put("Sidorov", "Semen");
    map.put("Pen", "Semen");
    map.put("Nosin", "Napoleon");
    map.put("PUtin", "Semen");
    map.put("Cherezzabornogyzaderi", "Petr");
    return (HashMap<String, String>) map;

  }

  public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
    ArrayList<String> keyList = new ArrayList<>();
    int count;
    String currentName;
    String currentKey;
    String tempName;
    Boolean chek;
    label:
    for (int i = 0; i < 15; i++) {
      count = 0;
      currentKey = null;
      tempName = "";
      chek = false;
      for (Map.Entry<String, String> pair : map.entrySet()) {
        currentKey = pair.getKey();
        if (!keyList.isEmpty()) {
          if (keyList.contains(currentKey)) {
            continue;
          }
          chek = false;
        }
        currentName = pair.getValue();
        if (!chek) {
          tempName = currentName;
          chek = true;
        }
        if (currentName.equals(tempName)) {
          count++;
        }
      }
      switch (count) {
        case 0:
          break label;
        case 1:
          keyList.add(currentKey);
          break;
        default:
          removeItemFromMapByValue(map, tempName);
          break;
      }
    }
  }

  private static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
    HashMap<String, String> copy = new HashMap<>(map);
    for (Map.Entry<String, String> pair : copy.entrySet()) {
      if (pair.getValue().equals(value)) {
        map.remove(pair.getKey());
      }
    }
  }
}
