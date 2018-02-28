package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
class Solution {

  public static void main(String[] args) {
    byte[][] a = new byte[][]{
        {1, 1, 0, 0},
        {1, 1, 0, 0},
        {1, 1, 0, 0},
        {1, 1, 0, 1}
    };
    int count = getRectangleCount(a);
    System.out.println("count = " + count + ". Должно быть 2");
  }

  private static int getRectangleCount(byte[][] a) {
    int hor = a[0].length;
    int ver = a.length;
    int count;
    int verEnd;
    int horEnd;
    int result = 0;
    for (int i = 0; i < ver; i++) {
      for (int j = 0; j < hor; j++) {
        if (a[i][j] == 1) {
          //по вертикали
          count = i + 1;
          System.out.println("a[" + count + "][" + j + "]");
          while (true) {
            if (count >= ver || (a[count][j] == 0 && count < ver)) {
              verEnd = count - 1;
              System.out.println("verEnd = " + verEnd);
              break;
            }
            count++;
            System.out.println("a[" + count + "][" + j + "]");
          }
          //по горизонтали
          count = j + 1;
          while (true) {
            if (count >= hor || (a[i][count] == 0 && count < hor)) {
              horEnd = count - 1;
              System.out.println("horEnd = " + horEnd);
              break;
            }
            count++;
          }
          boolean flag = true;
          for (int p = i; p <= verEnd; p++) {
            for (int q = j; q <= horEnd; q++) {
              if (a[p][q] != 1) {
                flag = false;
                break;
              }
            }
          }
          if (flag) {
            System.out.println("startI = " + i);
            System.out.println("startJ = " + j);
            System.out.println("endI = " + verEnd);
            System.out.println("endJ = " + horEnd);
            for (int p = i; p <= verEnd; p++) {
              for (int q = j; q <= horEnd; q++) {
                a[p][q] = 0;
              }
            }
            result++;
          }
          System.out.println();
        }
      }
    }
    return result;
  }
}























