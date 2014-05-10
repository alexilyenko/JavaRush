package com.javarush.test.level19.lesson03.task02;

import java.io.IOException;

public interface AmigoStringWriter {
    public void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}
