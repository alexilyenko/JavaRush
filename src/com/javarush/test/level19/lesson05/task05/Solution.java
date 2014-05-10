package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> list = new ArrayList<String>();
        String nextLine;
        while ((nextLine = fileReader.readLine()) != null) {
            list.add(nextLine);
        }
        fileReader.close();

        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2));
        for (String aString : list)
        {
            aString = aString.replaceAll("\\p{Punct}", "");
            printWriter.println(aString);
        }
        printWriter.close();
    }
}
