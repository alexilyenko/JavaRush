package com.javarush.test.level25.lesson16.big01;

/**
 * Класс для НЛО
 */
public class Ufo extends BaseObject {

  //картинка для отрисовки
  private static final int[][] matrix = {
      {0, 0, 0, 0, 0},
      {0, 0, 1, 0, 0},
      {1, 1, 1, 1, 1},
      {0, 1, 1, 1, 0},
      {0, 0, 0, 0, 0},
  };

  public Ufo(double x, double y) {
    super(x, y, 3);
  }

  /**
   * Метод рисует свой объект на "канвасе".
   */
  @Override
  public void draw(Canvas canvas) {
    canvas.drawMatrix(x - radius + 1, y, matrix, 'U');
  }

  /**
   * Двигаем себя на один ход в случайном направлении.
   */
  @Override
  public void move() {
    double dx = Math.random() * 2 - 1;
    double dy = Math.random() * 2 - 1;

    x += dx;
    y += dy;

    checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() / 2);

    int random10 = (int) (Math.random() * 10);
    if (random10 == 0) {
      fire();
    }
  }

  /**
   * Стреляем.
   * Сбрасываем(создаем) одну бомбу прямо под собой.
   */
  private void fire() {
    Space.game.getBombs().add(new Bomb(x, y + 3));
  }
}
