package com.javarush.test.level14.lesson08.home10;

import java.util.LinkedList;
import java.util.List;

/* Исправить 4 ошибки
Исправить 4 ошибки в конструкторе NotIncapsulatedClass и отрефактори код
1. В класе NotIncapsulatedClass создать private методы initList, printListValues, processCastedObjects.
2. Метод initList должен заполнять значениями входящий параметр list:
- найди нужный блок кода в конструкторе, в котором list заполняется значениями
- перенеси его в метод initList
- верни заполненный list.
3. Метод printListValues должен принимать параметр list и вывести в консоль все элементы из списка list:
- метод ничего не возвращает
- найди нужный блок кода в конструкторе, в котором в цикле из списка list выводятся в консоль все значения
- перенеси его в метод printListValues
- исправь 2 ошибки в этом методе.
4. Метод processCastedObjects должен проверить:
- входящий параметр имеет тип Number
- метод ничего не возвращает
- найди нужный блок кода в конструкторе, в котором в цикле для каждого объекта из списка list проверяется его тип
- перенеси этот блок в метод processCastedObjects
- исправь 2 ошибки в этом методе
- учти, что для объекта типа Float нужно вывести "Is float value defined? " + [Float_object].isNaN()
- учти, что для объекта типа Double нужно вывести "Is double value infinite? " + [Double_object].isInfinite().
*/

class Solution {

  public static void main(String[] args) {
    new NotIncapsulatedClass();
  }

  static class NotIncapsulatedClass {

    NotIncapsulatedClass() {
      List<Number> thisList = initList();
      printListValues(thisList);
      processCastedObjects(thisList);
    }

    private List<Number> initList() {
      List<Number> list = new LinkedList<>();
      list.add((double) 1000f);
      list.add(new Double("123e-445632"));
      list.add((float) (-90 / -3));
      list.remove(new Double("123e-445632"));
      return list;
    }

    private void printListValues(List<Number> list) {
      for (Number aList : list) {
        System.out.println(aList);
      }
    }

    private void processCastedObjects(List<Number> list) {
      for (Number object : list) {
        //Исправь 2 ошибки
        if (object instanceof Double) {
          Double a = (Double) object;
          System.out.println("Is double value infinite? " + a.isInfinite());
        } else if (object instanceof Float) {
          Float a = (Float) object;
          System.out.println("Is float value defined? " + a.isNaN());

        }
      }

    }
  }
}
