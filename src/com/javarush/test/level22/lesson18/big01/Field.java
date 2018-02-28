package com.javarush.test.level22.lesson18.big01;

import java.util.ArrayList;

/**
 * Класс Field описывает "поле клеток" игры Тетрис
 */
public class Field {

  //ширина и высота
  private final int width;
  private final int height;

  //матрица поля: 1 - клетка занята, 0 - свободна
  private int[][] matrix;

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    matrix = new int[height][width];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[][] getMatrix() {
    return matrix;
  }

  /**
   * Метод возвращает значение, которое содержится в матрице с координатами (x,y)
   * Если координаты за пределами матрицы, метод возвращает null.
   */
  public Integer getValue(int x, int y) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      return matrix[y][x];
    }

    return null;
  }

  /**
   * Метод устанавливает переданное значение(value) в ячейку матрицы с координатами (x,y)
   */
  public void setValue(int x, int y, int value) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      matrix[y][x] = value;
    }
  }

  /**
   * Метод печатает на экран текущее содержание матрицы
   */
  public void print() {
    //Создаем массив, куда будем "рисовать" текущее состояние игры
    int[][] canvas = new int[height][width];

    //Копируем "матрицу поля" в массив
    for (int i = 0; i < height; i++) {
      System.arraycopy(matrix[i], 0, canvas[i], 0, width);
    }

    //Копируем фигурку в массив, только непустые клетки
    int left = Tetris.game.getFigure().getX();
    int top = Tetris.game.getFigure().getY();
    int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (top + i >= height || left + j >= width) {
          continue;
        }
        if (brickMatrix[i][j] == 1) {
          canvas[top + i][left + j] = 2;
        }
      }
    }

    //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
    System.out
        .println("---------------------------------------------------------------------------\n");

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int index = canvas[i][j];
        switch (index) {
          case 0:
            System.out.print(" . ");
            break;
          case 1:
            System.out.print(" X ");
            break;
          case 2:
            System.out.print(" X ");
            break;
          default:
            System.out.print("???");
            break;
        }
      }
      System.out.println();
    }

    System.out.println();
    System.out.println();
  }

  /**
   * Удаляем заполненные линии
   */
  public void removeFullLines() {
    //Создаем список для хранения линий
    ArrayList<int[]> lines = new ArrayList<>();

    //Копируем все непустые линии в список.
    for (int i = 0; i < height; i++) {
      //подсчитываем количество единиц в строке - просто суммируем все ее значения
      int count = 0;
      for (int j = 0; j < width; j++) {
        count += matrix[i][j];
      }

      //Если сумма строки не равно ее ширине - добавляем в список
      if (count != width) {
        lines.add(0, matrix[i]);
      }
    }

    //Добавляем недостающие строки в начало списка.
    while (lines.size() < height) {
      lines.add(0, new int[width]);
    }

    //Преобразуем список обратно в матрицу
    matrix = lines.toArray(new int[height][width]);
  }
}
