package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


class Solution {

  public static void main(String[] args) throws IOException {
    Map<Integer, Boolean> tagIndexes = new TreeMap<>();
    Map<Integer, Integer> finalIndexes = new TreeMap<>();
    Stack<Integer> openTagsStack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    String openTag = "<" + args[0];
    String closeTag = "</" + args[0] + ">";

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
    reader.close();

    while (fileReader.ready()) {
      sb.append(fileReader.readLine());
    }
    fileReader.close();

    int openTagIndex = sb.indexOf(openTag);
    while (openTagIndex != -1) {
      tagIndexes.put(openTagIndex, true);
      openTagIndex = sb.indexOf(openTag, openTagIndex + 1);
    }

    int closeTagIndex = sb.indexOf(closeTag);
    while (closeTagIndex != -1) {
      tagIndexes.put(closeTagIndex, false);
      closeTagIndex = sb.indexOf(closeTag, closeTagIndex + 1);
    }

    for (Map.Entry<Integer, Boolean> entry : tagIndexes.entrySet()) {
      if (entry.getValue()) {
        openTagsStack.push(entry.getKey());
      } else {
        finalIndexes.put(openTagsStack.pop(), entry.getKey());
      }
    }

    for (Map.Entry<Integer, Integer> entry : finalIndexes.entrySet()) {
      System.out.println(sb.substring(entry.getKey(), entry.getValue() + closeTag.length()));
    }
  }
}

