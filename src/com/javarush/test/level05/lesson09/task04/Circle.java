package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius  width, color
*/

    public class Circle
    {
        private int centerX, centerY, radius, width;
        private String color;

        public Circle (int centerX, int centerY, int radius, int width, String color) {
            this.centerX=centerX;
            this.centerY=centerY;
            this.radius=radius;
            this.width=width;
            this.color=color;
        }

        public Circle (int centerX, int centerY, int radius, int width) {
            this.centerX=centerX;
            this.centerY=centerY;
            this.radius=radius;
            this.width=width;
        }

        public Circle (int centerX, int centerY, int radius) {
            this.centerX=centerX;
            this.centerY=centerY;
            this.radius=radius;
        }
    }
