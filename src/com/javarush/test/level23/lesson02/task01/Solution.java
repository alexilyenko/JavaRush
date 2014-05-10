package com.javarush.test.level23.lesson02.task01;

/* Запретите наследование
Запретите наследование от класса Listener.
*/
public class Solution {

    public static final class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}
