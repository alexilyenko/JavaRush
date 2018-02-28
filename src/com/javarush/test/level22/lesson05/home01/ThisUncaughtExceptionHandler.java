package com.javarush.test.level22.lesson05.home01;

class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    final String string = "%s : %s : %s";
    switch (t.getName()) {
      case Solution.FIRST_THREAD_NAME:
        System.out.println(getFormattedStringForFirstThread(t, e, string));
        break;
      case Solution.SECOND_THREAD_NAME:
        System.out.println(getFormattedStringForSecondThread(t, e, string));
        break;
      default:
        System.out.println(getFormattedStringForOtherThread(t, e, string));
        break;
    }
  }

  private String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
    return String.format(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
  }

  private String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
    return String.format(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
  }

  private String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
    return String.format(string, t.getName(), e.getClass().getSimpleName(), e.getCause());
  }
}

