package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


public class ImageReaderFactory
{
    private static ImageReader imageReader;
    public static ImageReader getReader(ImageTypes imageReaderType) {
        if (imageReaderType == ImageTypes.BMP)
            imageReader = new BmpReader();
        else if (imageReaderType == ImageTypes.PNG)
            imageReader = new PngReader();
        else if (imageReaderType == ImageTypes.JPG)
            imageReader = new JpgReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");

        return imageReader;
    }
}
