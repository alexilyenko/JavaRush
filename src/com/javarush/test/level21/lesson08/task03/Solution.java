package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }

     }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }

    }

    public static class C extends B  {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        private C duplicate(C c)
        {
            return new C(c.getI(), c.getJ(), c.getName());
        }
        @Override
        public C clone() throws CloneNotSupportedException
        {
            return duplicate(this);
        }
    }
}
