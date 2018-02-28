package com.javarush.test.level14.lesson08.home06;

/* MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Triller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".
Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
6. Добавить в MovieFactory.getMovie получение объекта Triller для ключа "triller".

7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "triller", "soapOpera".
8. Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> movies = new ArrayList<>();

    while (true) {
      String movieName = br.readLine();
      if (movieName.equals("cartoon") || movieName.equals("triller") || movieName
          .equals("soapOpera")) {
        movies.add(movieName);
      } else {
        break;
      }
    }
    for (String movieKey : movies) {
      Movie movie = MovieFactory.getMovie(movieKey);
      System.out.println(movie.getClass().getSimpleName());
    }
  }

  static class MovieFactory {

    static Movie getMovie(String key) {
      Movie movie = null;

      switch (key) {
        case "soapOpera":
          movie = new SoapOpera();
          break;
        case "cartoon":
          movie = new Cartoon();
          break;
        case "triller":
          movie = new Triller();
          break;
      }
      return movie;
    }
  }

  static abstract class Movie {

  }

  static class SoapOpera extends Movie {

  }

  static class Triller extends Movie {

  }

  static class Cartoon extends Movie {

  }
}
