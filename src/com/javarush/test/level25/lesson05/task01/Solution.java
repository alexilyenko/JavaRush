package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
class Solution {

  public static void processThreads(Thread... threads) {
    for (Thread currentThread : threads) {
      switch (currentThread.getState()) {
        case NEW:
          currentThread.start();
          break;
        case RUNNABLE:
          currentThread.isInterrupted();
          break;
        case BLOCKED:
          currentThread.interrupt();
          break;
        case WAITING:
          currentThread.interrupt();
          break;
        case TIMED_WAITING:
          currentThread.interrupt();
          break;
        case TERMINATED:
          System.out.println(currentThread.getPriority());
          break;
      }
    }
  }
}
