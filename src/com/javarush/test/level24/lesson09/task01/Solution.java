package com.javarush.test.level24.lesson09.task01;

/* Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS
*/
public class Solution extends C {
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}

interface JustAnInterface {
    public static final B B = new B();

    class B extends C {
        public B() {
            System.out.print("B");
        }
    }
}

class C implements JustAnInterface {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}



