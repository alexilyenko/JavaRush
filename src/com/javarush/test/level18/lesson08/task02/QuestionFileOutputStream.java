package com.javarush.test.level18.lesson08.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

  private final AmigoOutputStream amigoOutputStream;

  public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
    this.amigoOutputStream = amigoOutputStream;
  }

  @Override
  public void flush() throws IOException {
    amigoOutputStream.flush();
  }

  @Override
  public void write(int b) throws IOException {
    amigoOutputStream.write(b);
  }

  @Override
  public void write(byte[] b) throws IOException {
    amigoOutputStream.write(b);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    amigoOutputStream.write(b, off, len);
  }

  @Override
  public void close() throws IOException {
    System.out.println("Вы действительно хотите закрыть поток? Д/Н");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    reader.close();
    if (input.equalsIgnoreCase("Д")) {
      amigoOutputStream.close();
    }
  }
}

