package com.javarush.test.level24.lesson04.home02;

public class SecondClass implements Action {   //second implementation

  public static final String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

  private static final String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";
  private final StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

  SecondClass() {
    Solution.countActionObjects++;
  }

  public void someAction() {
    System.out.println(sb.toString());
  }
}
