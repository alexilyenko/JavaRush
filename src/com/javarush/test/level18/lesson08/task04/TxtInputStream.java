package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

class TxtInputStream extends FileInputStream {

  public TxtInputStream(String fileName)
      throws FileNotFoundException, UnsupportedFileNameException {
    super(fileName);
    if (!fileName.endsWith(".txt")) {
      throw new UnsupportedFileNameException();
    }
  }
}

