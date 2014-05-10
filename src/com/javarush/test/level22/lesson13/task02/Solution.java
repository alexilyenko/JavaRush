package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        List<String> lines = new ArrayList<>();
        while (fileReader.ready())
            lines.add(fileReader.readLine());
        fileReader.close();

        List<String> decodedLines = new ArrayList<>();
        for (String currentLine : lines)
            decodedLines.add(new String(currentLine.getBytes("Windows-1251")));

        PrintWriter printWriter = new PrintWriter(new FileWriter(args[1]));
        for (String currentLine : decodedLines)
            printWriter.println(currentLine);
        printWriter.close();
    }
}
