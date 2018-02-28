package com.javarush.test.level17.lesson10.home07;

import java.util.HashMap;
import java.util.Map;

/* ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {

  private final Map<String, GenericsBean> container = new HashMap<>();

  protected ApplicationContext() {
    parseAllClassesAndInterfaces();
  }

  public synchronized GenericsBean getByName(String name) {
    return container.get(name);
  }

  public synchronized GenericsBean removeByName(String name) {
    return container.remove(name);
  }

  abstract void parseAllClassesAndInterfaces();
}
