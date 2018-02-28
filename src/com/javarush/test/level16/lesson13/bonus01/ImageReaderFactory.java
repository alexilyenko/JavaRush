package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.BmpReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageTypes;
import com.javarush.test.level16.lesson13.bonus01.common.JpgReader;
import com.javarush.test.level16.lesson13.bonus01.common.PngReader;


class ImageReaderFactory {

  @SuppressWarnings("FieldCanBeLocal")
  private static ImageReader imageReader;

  public static ImageReader getReader(ImageTypes imageReaderType) {
    switch (imageReaderType) {
      case BMP:
        imageReader = new BmpReader();
        break;
      case PNG:
        imageReader = new PngReader();
        break;
      case JPG:
        imageReader = new JpgReader();
        break;
      default:
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }

    return imageReader;
  }
}
