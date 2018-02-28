package com.javarush.test.level20.lesson02.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
class Solution {

  private static final Map<String, String> properties = new HashMap<>();
  private static final Properties props = new Properties();

  public static void main(String[] args) throws Exception {
    new Solution().fillInPropertiesMap();
    System.out.println(properties);
    new Solution().save(new FileOutputStream("d:/2.properties"));
  }

  private void fillInPropertiesMap() throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    InputStream fileProperties = new FileInputStream(bufferedReader.readLine());
    bufferedReader.close();
    load(fileProperties);
  }

  private void save(OutputStream outputStream) throws Exception {
    PrintWriter printWriter = new PrintWriter(outputStream);
    if (props.size() > 0) {
      props.putAll(properties);
    }
    props.store(outputStream, "");
    printWriter.close();
  }

  private void load(InputStream inputStream) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    props.load(inputStream);
    Set<String> list = props.stringPropertyNames();
    for (String current : list) {
      properties.put(current, props.getProperty(current));
    }
    bufferedReader.close();
  }
}
