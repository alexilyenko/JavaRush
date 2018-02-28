package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius  width, color
*/

class Circle {

  private final int centerX;
  private final int centerY;
  private final int radius;
  private int width;
  @SuppressWarnings("FieldCanBeLocal")
  private String color;

  public Circle(int centerX, int centerY, int radius, int width, String color) {
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.width = width;
    this.color = color;
  }

  public Circle(int centerX, int centerY, int radius, int width) {
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.width = width;
  }

  public Circle(int centerX, int centerY, int radius) {
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
  }
}
