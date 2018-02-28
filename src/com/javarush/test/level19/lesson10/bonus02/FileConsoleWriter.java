package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

class FileConsoleWriter extends FileWriter {

  private final int writeBufferSize = 1024;
  private char[] writeBuffer;

  public FileConsoleWriter(String fileName) throws IOException {
    super(fileName);
  }

  public FileConsoleWriter(String fileName, boolean append) throws IOException {
    super(fileName, append);
  }

  public FileConsoleWriter(File file) throws IOException {
    super(file);
  }

  public FileConsoleWriter(File file, boolean append) throws IOException {
    super(file, append);
  }

  public FileConsoleWriter(FileDescriptor fd) {
    super(fd);
  }

  public void write(int c) throws IOException {
    if (writeBuffer == null) {
      writeBuffer = new char[writeBufferSize];
    }
    writeBuffer[0] = (char) c;
    write(writeBuffer, 0, 1);
  }


  public void write(char[] cbuf) throws IOException {
    write(cbuf, 0, cbuf.length);
  }


  public void write(char[] cbuf, int off, int len) throws IOException {
    System.out.println(String.copyValueOf(cbuf).substring(off, off + len));
    super.write(cbuf, off, len);
  }


  public void write(String str) throws IOException {
    write(str, 0, str.length());
  }


  public void write(String str, int off, int len) throws IOException {
    char cbuf[];
    if (len <= writeBufferSize) {
      if (writeBuffer == null) {
        writeBuffer = new char[writeBufferSize];
      }
      cbuf = writeBuffer;
    } else {    // Don't permanently allocate very large buffers.
      cbuf = new char[len];
    }
    str.getChars(off, (off + len), cbuf, 0);
    write(cbuf, 0, len);
  }
}