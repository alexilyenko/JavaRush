package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

  private final FileOutputStream fileOutputStream;

  public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
    this.fileOutputStream = fileOutputStream;
  }

  @Override
  public void flush() throws IOException {
    this.fileOutputStream.flush();
  }

  @Override
  public void writeString(String s) throws IOException {
    byte[] StringToBytes = s.getBytes();
    this.fileOutputStream.write(StringToBytes);
  }

  @Override
  public void close() throws IOException {
    this.fileOutputStream.close();
  }
}

