package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        try{
            String fileName;

            while(!(fileName = bufferedReader.readLine()).equals("exit")){
                 list.add(fileName);
            }
            bufferedReader.close();
            for(String s : list){
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();
            }
        }catch (Exception ignored){}

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try{
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    list.add(data);
                }
                fileInputStream.close();

                int max = 0;
                int id = 0;
                int count;

                for(int a = 0;a<list.size();a++){
                    count = Collections.frequency(list,list.get(a));
                    if(count>max){ max = count; id = list.get(a);}
                }

                resultMap.put(fileName,id);

            }catch (Exception ignored){}
        }
    }
}