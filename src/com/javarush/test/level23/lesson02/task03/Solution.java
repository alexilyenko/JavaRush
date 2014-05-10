package com.javarush.test.level23.lesson02.task03;

import java.util.List;

/* Запретите создание экземпляров класса
Запретите создание экземпляров класса Listener.
*/
public class Solution {

    public static abstract class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}
