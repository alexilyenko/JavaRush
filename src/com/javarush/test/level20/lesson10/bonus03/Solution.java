package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
class Solution {

  public static void main(String[] args) {
    int[][] crossword = new int[][]{
        //i   0    1    2    3    4    5       j
        {'f', 'd', 'e', 'r', 'l', 'k'},  //0
        {'u', 's', 'a', 'm', 'e', 'b'},  //1
        {'y', 'n', 'g', 'r', 'o', 'v'},  //2
        {'x', 'l', 'p', 'r', 'r', 'h'},  //3
        {'p', 'o', 'z', 'e', 'j', 'j'}   //4
    };
    detectAllWords(crossword, "fsgrj", "fsgr", "grj", "moh", "npe", "ylz", "lb");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
  }

  @SuppressWarnings("UnusedReturnValue")
  private static List<Word> detectAllWords(int[][] crossword, String... words) {

    ArrayList<Word> result = new ArrayList<>();
    int hor = crossword[0].length;
    int ver = crossword.length;

    outer:
    for (String s : words) {
      //по горизонтали
      for (int i = 0; i < ver; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < hor; j++) {
          sb.append((char) crossword[i][j]);
        }

        String horLine = sb.toString();
        //noinspection Duplicates
        if (horLine.contains(s)) {
          Word word = new Word(s);
          word.setStartPoint(horLine.indexOf(s), i);
          word.setEndPoint(horLine.indexOf(s) + s.length() - 1, i);

          result.add(word);
          continue outer;
        }
        String horReverse = sb.reverse().toString();
        if (horReverse.contains(s)) {
          Word word = new Word(s);
          word.setStartPoint(hor - horReverse.indexOf(s) - 1, i);
          word.setEndPoint(hor - horReverse.indexOf(s) - s.length(), i);

          result.add(word);
          continue outer;
        }
      }
      //по вертикали
      for (int i = 0; i < hor; i++) {
        StringBuilder sb = new StringBuilder();
        for (int[] aCrossword : crossword) {
          sb.append((char) aCrossword[i]);
        }

        String horLine = sb.toString();
        //noinspection Duplicates
        if (horLine.contains(s)) {
          Word word = new Word(s);
          word.setStartPoint(i, horLine.indexOf(s));
          word.setEndPoint(i, horLine.indexOf(s) + s.length() - 1);

          result.add(word);
          continue outer;
        }
        String horReverse = sb.reverse().toString();
        if (horReverse.contains(s)) {
          Word word = new Word(s);
          word.setStartPoint(i, ver - horReverse.indexOf(s) - 1);
          word.setEndPoint(i, ver - s.length() - horReverse.indexOf(s));

          result.add(word);
          continue outer;
        }
      }

      //по диагонали вправо
      for (int i = 0; i < ver; i++) {
        for (int j = 0; j < hor; j++) {
          int iTemp = i;
          int jTemp = j;
          StringBuilder sb = new StringBuilder();
          while (iTemp < ver && jTemp < hor) {
            sb.append((char) crossword[iTemp][jTemp]);
            iTemp++;
            jTemp++;
          }
          String horLine = sb.toString();
          if (horLine.contains(s)) {
            Word word = new Word(s);
            word.setStartPoint(j + horLine.indexOf(s), i + horLine.indexOf(s));
            word.setEndPoint(j + horLine.indexOf(s) + s.length() - 1,
                i + horLine.indexOf(s) + s.length() - 1);

            result.add(word);
            continue outer;
          }
          String horReverse = sb.reverse().toString();
          if (horReverse.contains(s)) {
            Word word = new Word(s);
            word.setStartPoint(jTemp - 1 - horReverse.indexOf(s),
                iTemp - 1 - horReverse.indexOf(s));
            word.setEndPoint(jTemp - horReverse.indexOf(s) - s.length(),
                iTemp - horReverse.indexOf(s) - s.length());

            result.add(word);
            continue outer;
          }
        }
      }

      //по диагонали влево
      for (int i = 0; i < ver; i++) {
        for (int j = hor - 1; j >= 0; j--) {
          int iTemp = i;
          int jTemp = j;
          StringBuilder sb = new StringBuilder();
          while (iTemp < ver && jTemp >= 0) {
            sb.append((char) crossword[iTemp][jTemp]);
            iTemp++;
            jTemp--;
          }

          String horLine = sb.toString();
          if (horLine.contains(s)) {
            Word word = new Word(s);
            word.setStartPoint(j - horLine.indexOf(s), i + horLine.indexOf(s));
            word.setEndPoint(j - horLine.indexOf(s) - s.length() + 1,
                i + horLine.indexOf(s) + s.length() - 1);

            result.add(word);
            continue outer;
          }
          String horReverse = sb.reverse().toString();
          if (horReverse.contains(s)) {
            Word word = new Word(s);
            word.setStartPoint(jTemp + 1 + horReverse.indexOf(s),
                iTemp - 1 - horReverse.indexOf(s));
            word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(),
                iTemp - horReverse.indexOf(s) - s.length());

            result.add(word);
            continue outer;
          }
        }
      }
    }
    System.out.println(result);

    return result;
  }


  static class Word {

    private final String text;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    Word(String text) {
      this.text = text;
    }

    void setStartPoint(int i, int j) {
      startX = i;
      startY = j;
    }

    void setEndPoint(int i, int j) {
      endX = i;
      endY = j;
    }

    @Override
    public String toString() {
      return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
    }
  }
}
