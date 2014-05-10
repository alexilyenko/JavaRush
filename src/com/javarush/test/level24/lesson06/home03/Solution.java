package com.javarush.test.level24.lesson06.home03;

import java.util.List;

/* Интернет-магазин продажи джинсов
1.Внутри файла Solution.java, но НЕ внутри класса Solution создайте 2 интерфейса:
1.1) Item с методами int getId(), double getPrice(), String getTM()
1.2) Jeans extends Item с методами int getLength() и int getSize()
2. В классе Util в методе getAllJeans добавьте пропущенную часть java-кода:
2.1) разберитесь в том, что уже есть в методе getAllJeans класса Util
2.2) создайте абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуйте остальные методы
2.3) создайте классы Levis и Denim от AbstractJeans, реализуйте оставшийся метод
2.4) в классе AbstractJeans реализуйте метод toString() используя  Alt+Insert -> toString()
2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}
*/
public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}

interface Item {
    public int getId();
    public double getPrice();
    public String getTM();
}

interface Jeans extends Item {
    public int getLength();
    public int getSize();
}
