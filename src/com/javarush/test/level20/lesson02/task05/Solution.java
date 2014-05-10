package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File myFile = new File ("d:/1.txt");
            OutputStream outputStream = new FileOutputStream(myFile);
            InputStream inputStream = new FileInputStream(myFile);

            Object object = new Object();
            object.string1 = new String();
            object.string2 = new String();
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String();
            loadedObject.string2 = new String();

            loadedObject.load(inputStream);

            object.string1.print();
            loadedObject.string1.print();
            object.string2.print();
            loadedObject.string2.print();

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            java.lang.String hasString1 = (string1 != null) ? "yes" : "no";
            printWriter.println(hasString1);
            currentValue = countStrings - 1;
            java.lang.String hasString2 = (string2 != null) ? "yes" : "no";
            printWriter.println(hasString2);
            currentValue = currentValue--;
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            int tmp = countStrings;
            countStrings = currentValue;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            java.lang.String hasString1 = bufferedReader.readLine();
            if ("yes".equals(hasString1))
                this.string1 = new String();
            java.lang.String hasString2= bufferedReader.readLine();
            if ("yes".equals(hasString2))
                this.string2 = new String();
            bufferedReader.close();
            countStrings = tmp;
        }
    }

    public static int currentValue;
    public static int countStrings;

    public static class String
    {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
