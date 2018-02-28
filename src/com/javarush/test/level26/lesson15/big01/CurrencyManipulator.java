package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alex on 28.04.2014.
 */
public class CurrencyManipulator {

  private final String currencyCode;
  private final Map<Integer, Integer> denominations = new HashMap<>();

  public CurrencyManipulator(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public boolean isAmountAvailable(int expectedAmount) {
    return expectedAmount <= getTotalAmount();
  }

  @SuppressWarnings("UnusedReturnValue")
  public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
    int sum = expectedAmount;
    HashMap<Integer, Integer> temp = new HashMap<>();
    denominations.putAll(temp);
    ArrayList<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> pair : temp.entrySet()) {
      list.add(pair.getKey());
    }

    Collections.sort(list);
    Collections.reverse(list);

    TreeMap<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());

    for (Integer aList : list) {
      int key = aList;
      int value = temp.get(key);
      while (true) {
        if (sum < key || value <= 0) {
          temp.put(key, value);
          break;
        }
        sum -= key;
        value--;

        if (result.containsKey(key)) {
          result.put(key, result.get(key) + 1);
        } else {
          result.put(key, 1);
        }
      }
    }

    if (sum > 0) {
      throw new NotEnoughMoneyException();
    } else {
      for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
      }

      denominations.clear();
      denominations.putAll(temp);
      ConsoleHelper.writeMessage("Transaction was successful!");
    }
    return result;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void addAmount(int denomination, int count) {
    if (denominations.containsKey(denomination)) {
      denominations.put(denomination, denominations.get(denomination) + count);
    } else {
      denominations.put(denomination, count);
    }
  }

  public int getTotalAmount() {
    int result = 0;
    for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
      result = result + (pair.getKey() * pair.getValue());
    }

    return result;
  }

  public boolean hasMoney() {
    return denominations.size() != 0;
  }
}
