package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

class ConsoleReader {

  @SuppressWarnings("UnusedReturnValue")
  private static String readString() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
  }

  public static int readInt() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(reader.readLine());
  }

  @SuppressWarnings("unused")
  public static double readDouble() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    return Double.parseDouble(reader.readLine());
  }

  public static void readLn() throws Exception {
    ConsoleReader.readString();
  }
}
