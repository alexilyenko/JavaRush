package com.javarush.test.level22.lesson18.big01;

/**
 * Класс FigureFactory отвечает за создание объектов-фигурок.
 */
class FigureFactory {

  /**
   * Набор из шести шаблонов для фигурок
   */
  private static final int[][][] BRICKS = {{
      {1, 1, 0},                          //   X X
      {0, 1, 1},                          //     X X
      {0, 0, 0}}, {                       //

      {1, 0, 0},                          //   X
      {1, 1, 0},                          //   X X
      {0, 1, 0}}, {                       //     X

      {0, 1, 0},                          //   X
      {0, 1, 0},                          //   X
      {0, 1, 0}}, {                       //   X

      {1, 1, 0},                          //   X X
      {1, 1, 0},                          //   X X
      {0, 0, 0}}, {                       //

      {1, 1, 1},                          //   X X X
      {0, 1, 0},                          //     X
      {0, 0, 0}}, {                       //

      {1, 1, 1},                          //   X X X
      {1, 1, 1},                          //   X X X
      {0, 0, 0}}                          //
  };

  /**
   * Метод выбирает случайный шаблон и создает с ним новую фигурку.
   */
  public static Figure createRandomFigure(int x, int y) {
    int index = (int) (Math.random() * 6);
    return new Figure(x, y, BRICKS[index]);
  }
}
