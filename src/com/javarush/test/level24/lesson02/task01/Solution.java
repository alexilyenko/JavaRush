package com.javarush.test.level24.lesson02.task01;

/* Cloneable
Добавьте java-код, чтобы метод main отработал без исключений.
Удалять что-либо нельзя.
*/
public class Solution {

  public static void main(String[] args) throws CloneNotSupportedException {
    Test1 test1 = new Test1();
    test1.clone();

    Test2 test2 = new Test2();
    test2.clone(new Test2());

    Test3 test3 = new Test3();
    test3.c1one();

    Test4 test4 = new Test4();
    test4.clone();
  }


  protected static class Test1 implements Cloneable {

    protected Test1 clone() throws CloneNotSupportedException {
      return (Test1) super.clone();
    }
  }

  @SuppressWarnings("UnusedReturnValue")
  static class Test2 extends Test1 {

    Test2 clone(Test2 test2) throws CloneNotSupportedException {
      return (Test2) test2.clone();
    }
  }

  static class Test3 implements Cloneable {

    @SuppressWarnings("UnusedReturnValue")
    Object c1one() {
      return new Test3();
    }
  }

  protected static class Test4 extends Test3 {

    protected Test4 clone() throws CloneNotSupportedException {
      return (Test4) super.clone();
    }
  }
}
