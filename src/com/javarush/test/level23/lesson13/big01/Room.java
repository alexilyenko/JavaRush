package com.javarush.test.level23.lesson13.big01;


import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Основной класс программы.
 */
public class Room {

  //Массив "пауз" в зависимости от уровня.
  private static final int[] levelDelay = {1000, 600, 550, 500, 480, 460, 440, 420, 400, 380, 360,
      340,
      320, 300, 285, 270};
  public static Room game;
  private int width;
  private int height;
  private Snake snake;
  private Mouse mouse;

  private Room(int width, int height, Snake snake) {
    this.width = width;
    this.height = height;
    this.snake = snake;
  }

  public static void main(String[] args) {
    game = new Room(20, 20, new Snake(10, 10));
    game.snake.setDirection(SnakeDirection.DOWN);
    game.createMouse();
    game.run();
  }

  public Snake getSnake() {
    return snake;
  }

  public void setSnake(Snake snake) {
    this.snake = snake;
  }

  public Mouse getMouse() {
    return mouse;
  }

  public void setMouse(Mouse mouse) {
    this.mouse = mouse;
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

  /**
   * Основной цикл программы.
   * Тут происходят все важные действия
   */
  private void run() {
    //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
    KeyboardObserver keyboardObserver = new KeyboardObserver();
    keyboardObserver.start();

    //пока змея жива
    while (snake.isAlive()) {
      //"наблюдатель" содержит события о нажатии клавиш?
      if (keyboardObserver.hasKeyEvents()) {
        KeyEvent event = keyboardObserver.getEventFromTop();
        //Если равно символу 'q' - выйти из игры.
        if (event.getKeyChar() == 'q') {
          return;
        }

        //Если "стрелка влево" - сдвинуть фигурку влево
        switch (event.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            snake.setDirection(SnakeDirection.LEFT);
            break;
          //Если "стрелка вправо" - сдвинуть фигурку вправо
          case KeyEvent.VK_RIGHT:
            snake.setDirection(SnakeDirection.RIGHT);
            break;
          //Если "стрелка вверх" - сдвинуть фигурку вверх
          case KeyEvent.VK_UP:
            snake.setDirection(SnakeDirection.UP);
            break;
          //Если "стрелка вниз" - сдвинуть фигурку вниз
          case KeyEvent.VK_DOWN:
            snake.setDirection(SnakeDirection.DOWN);
            break;
        }
      }

      snake.move(0, 2);   //двигаем змею
      print();        //отображаем текущее состояние игры
      sleep();        //пауза между ходами
    }

    //Выводим сообщение "Game Over"
    System.out.println("Game Over!");
  }

  /**
   * Выводим на экран текущее состояние игры
   */
  private void print() {
    //Создаем массив, куда будем "рисовать" текущее состояние игры
    int[][] matrix = new int[height][width];

    //Рисуем все кусочки змеи
    ArrayList<SnakeSection> sections = new ArrayList<>(snake.getSections());
    for (SnakeSection snakeSection : sections) {
      matrix[snakeSection.getY()][snakeSection.getX()] = 1;
    }

    //Рисуем голову змеи (4 - если змея мертвая)
    matrix[snake.getY()][snake.getX()] = snake.isAlive() ? 2 : 4;

    //Рисуем мышь
    matrix[mouse.getY()][mouse.getX()] = 3;

    //Выводим все это на экран
    String[] symbols = {" . ", " x ", " X ", "^_^", "RIP"};
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        System.out.print(symbols[matrix[y][x]]);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
    System.out.println();
  }

  /**
   * Метод вызывается, когда мышь съели
   */
  public void eatMouse() {
    createMouse();
  }

  /**
   * Создает новую мышь
   */
  private void createMouse() {
    int x = (int) (Math.random() * width);
    int y = (int) (Math.random() * height);

    mouse = new Mouse(x, y);
  }

  /**
   * Прогрмма делает паузу, длинна которой зависит от длинны змеи.
   */
  private void sleep() {
    try {
      int level = snake.getSections().size();
      int delay = level < 15 ? levelDelay[level] : 250;
      Thread.sleep(delay);
    } catch (InterruptedException ignored) {
    }
  }
}
