package com.javarush.test.level24.lesson14.big01;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Главный класс игры
 */
public class Arcanoid {

  public static Arcanoid game;
  //список кирпичей
  private final ArrayList<Brick> bricks = new ArrayList<>();
  //ширина и высота
  private int width;
  private int height;
  //шарик
  private Ball ball;
  //подставка
  private Stand stand;
  //игра закончена?
  private boolean isGameOver = false;

  private Arcanoid(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static void main(String[] args) throws Exception {
    game = new Arcanoid(20, 30);

    Ball ball = new Ball(10, 29, 2, 95);
    game.setBall(ball);

    Stand stand = new Stand(10, 30);
    game.setStand(stand);

    game.getBricks().add(new Brick(3, 3));
    game.getBricks().add(new Brick(7, 5));
    game.getBricks().add(new Brick(12, 5));
    game.getBricks().add(new Brick(16, 3));

    game.run();
  }

  private ArrayList<Brick> getBricks() {
    return bricks;
  }

  public Ball getBall() {
    return ball;
  }

  private void setBall(Ball ball) {
    this.ball = ball;
  }

  public Stand getStand() {
    return stand;
  }

  private void setStand(Stand stand) {
    this.stand = stand;
  }

  /**
   * Рисуем на холсте границы и все объекты.
   */
  private void draw(Canvas canvas) {
    drawBoders(canvas);
    for (Brick current : bricks) {
      current.draw(canvas);
    }
    ball.draw(canvas);
    stand.draw(canvas);
    //отрисуй границы
    //отрисуй кирпичи
    //отрисуй шарик
    //отрисуй подставку
  }

  /**
   * Рисуем на холсте границы
   */
  private void drawBoders(Canvas canvas) {
    //draw game
    for (int i = 0; i < width + 2; i++) {
      for (int j = 0; j < height + 2; j++) {
        canvas.setPoint(i, j, '.');
      }
    }

    for (int i = 0; i < width + 2; i++) {
      canvas.setPoint(i, 0, '-');
      canvas.setPoint(i, height + 1, '-');
    }

    for (int i = 0; i < height + 2; i++) {
      canvas.setPoint(0, i, '|');
      canvas.setPoint(width + 1, i, '|');
    }
  }

  /**
   * Основной цикл программы.
   * Тут происходят все важные действия
   */
  private void run() throws Exception {
    //Создаем холст для отрисовки.
    Canvas canvas = new Canvas(width, height);

    //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
    KeyboardObserver keyboardObserver = new KeyboardObserver();
    keyboardObserver.start();

    //Исполняем цикл, пока игра не окончека
    while (!isGameOver) {
      //"наблюдатель" содержит события о нажатии клавиш?
      if (keyboardObserver.hasKeyEvents()) {
        KeyEvent event = keyboardObserver.getEventFromTop();

        //Если "стрелка влево" - сдвинуть фигурку влево
        switch (event.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            stand.moveLeft();
            break;
          //Если "стрелка вправо" - сдвинуть фигурку вправо
          case KeyEvent.VK_RIGHT:
            stand.moveRight();
            break;
          //Если "пробел" - запускаем шарик
          case KeyEvent.VK_SPACE:
            ball.start();
            break;
        }
      }

      //двигаем все объекты
      move();

      //проверяем столкновения
      checkBricksBump();
      checkStandBump();

      //проверяем, что шарик мог улететь через дно.
      checkEndGame();

      //отрисовываем все объекты
      canvas.clear();
      draw(canvas);
      canvas.print();

      //пауза
      Thread.sleep(300);
    }

    //Выводим сообщение "Game Over"
    System.out.println("Game Over!");
  }

  /**
   * Двигаем шарик и подставку.
   */
  private void move() {
    ball.move();
    stand.move();
    //двигай шарик
    //двигай подставку
  }

  /**
   * Проверяем столкновение с кирпичами.
   * Если столкновение было - шарик отлетает в случайном направлении 0..360 градусов
   */
  private void checkBricksBump() {
    for (Brick currentBrick : bricks) {
      if (ball.isIntersec(currentBrick)) {
        double angel = Math.random() * 360;
        ball.setDirection(angel);
        bricks.remove(currentBrick);
        break;
      }
    }
  }

  /**
   * Проверяем столкновение с подставкой.
   * Если столкновение было - шарик отлетает в случайном направлении  вверх 80..100 градусов.
   */
  private void checkStandBump() {
    if (ball.isIntersec(stand)) {
      double angel = 80 + Math.random() * 20;
      ball.setDirection(angel);
    }
  }

  /**
   * Проверяем - не улетел ли шарик через дно.
   * Если да - игра окончена (isGameOver = true)
   */
  private void checkEndGame() {
    if (ball.getY() >= height) {
      isGameOver = true;
    }
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}



















