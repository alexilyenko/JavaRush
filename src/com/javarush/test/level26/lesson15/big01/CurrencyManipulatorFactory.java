package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Alex on 28.04.2014.
 */
@SuppressWarnings("ALL")
public final class CurrencyManipulatorFactory {

  static final HashMap<String, CurrencyManipulator> map = new HashMap<>();
  static boolean isExist = false;

  private CurrencyManipulatorFactory() {
  }

  public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
    isExist = false;
    CurrencyManipulator current;

    if (map.containsKey(currencyCode)) {
      return map.get(currencyCode);
    } else {
      current = new CurrencyManipulator(currencyCode);
      map.put(currencyCode, current);
      return current;
    }
  }

  public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
    return map.values();
  }


}
