package com.javarush.test.level22.lesson18.big01;

import java.awt.event.KeyEvent;

/**
 * Класс Tetris - содержит основной функционал игры.
 */
public class Tetris {

  public static Tetris game;
  private Field field;                //Поле с клетками
  private Figure figure;              //Фигурка
  private boolean isGameOver;         //Игра Окончена?

  private Tetris(int width, int height) {
    field = new Field(width, height);
    figure = null;
  }

  public static void main(String[] args) throws Exception {
    game = new Tetris(10, 20);
    game.run();
  }

  /**
   * Геттер переменной field.
   */
  public Field getField() {
    return field;
  }

  /**
   * Сеттер для field
   */
  public void setField(Field field) {
    this.field = field;
  }

  /**
   * Геттер переменной figure.
   */
  public Figure getFigure() {
    return figure;
  }

  /**
   * Сеттер для figure
   */
  public void setFigure(Figure figure) {
    this.figure = figure;
  }

  /**
   * Основной цикл программы.
   * Тут происходят все важные действия
   */
  private void run() throws Exception {
    //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
    KeyboardObserver keyboardObserver = new KeyboardObserver();
    keyboardObserver.start();

    //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
    isGameOver = false;
    //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
    figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

    //пока игра не окончена
    while (!isGameOver) {
      //"наблюдатель" содержит события о нажатии клавиш?
      if (keyboardObserver.hasKeyEvents()) {
        //получить самое первое событие из очереди
        KeyEvent event = keyboardObserver.getEventFromTop();
        //Если равно символу 'q' - выйти из игры.
        if (event.getKeyChar() == 'q') {
          return;
        }
        //Если "стрелка влево" - сдвинуть фигурку влево
        switch (event.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            figure.left();
            break;
          //Если "стрелка вправо" - сдвинуть фигурку вправо
          case KeyEvent.VK_RIGHT:
            figure.right();
            break;
          //Если  код клавишы равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
          case 12:
            figure.rotate();
            break;
          //Если "пробел" - фигурка падает вниз на максимум
          case KeyEvent.VK_SPACE:
            figure.downMaximum();
            break;
        }
      }

      step();             //делаем очередной шаг
      field.print();      //печатаем состояние "поля"
      Thread.sleep(300);  //пауза 300 миллисекунд - 1/3 секунды
    }

    //Выводим сообщение "Game Over"
    System.out.println("Game Over");
  }

  private void step() {
    //опускам фигурку вниз
    figure.down();

    //если разместить фигурку на текущем месте невозможно
    if (!figure.isCurrentPositionAvailable()) {
      figure.up();                    //поднимаем обратно
      figure.landed();                //приземляем

      isGameOver = figure.getY() <= 1;//если фигурка приземлилась на самом верху - игра окончена

      field.removeFullLines();        //удаляем заполненные линии

      figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0); //создаем новую фигурку
    }
  }
}
