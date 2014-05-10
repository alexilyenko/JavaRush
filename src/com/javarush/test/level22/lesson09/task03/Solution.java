package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String filename =br.readLine();
        String filename = "c:/file2.txt";
        br.close();
        FileInputStream fr = new FileInputStream(filename);
        // Используем сырые байты чтобы поиграть с котировками
        ByteArrayOutputStream rawByte = new ByteArrayOutputStream();
        List<String> tmp = new ArrayList<String>();
        while (fr.available()>0){
            int line = fr.read();
            rawByte.write(line);
        }
        fr.close();
        byte[]  buf = rawByte.toByteArray();
        String data = new String(buf);
        String[] res= data.split("\\s");
        for(int i=0;i<tmp.size();i++) res[i]=tmp.get(i);
        StringBuilder result = getLine(res);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words.length<1) return new StringBuilder();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<words.length;i++) {
            if(words[i].equals("")) continue;
            char start = words[i].toLowerCase().charAt(0);
            char end = words[i].toLowerCase().charAt(words[i].length() - 1);
            if(list.size()==0) {
                list.add(words[i]);
                words[i]="";
                i=-1;
                continue;
            }
            for(int k=0;k<list.size();k++) {
                // вставка в конец список
                char startList, endList;
                endList = list.get(list.size()-1).toLowerCase().charAt(list.get(list.size()-1).length() - 1);
                if(start==endList) {
                    list.add(words[i]);
                    words[i]="";
                    i=-1;
                    break;
                }
                // вставка в начало
                startList = list.get(0).toLowerCase().charAt(0);
                if(end==startList) {
                    list.add(0,words[i]);
                    words[i]="";
                    i=-1;
                    break;
                }
                // вставка в середину
                if(k<list.size()-1){
                    startList = list.get(k).toLowerCase().charAt(list.get(k).length()-1);
                    endList = list.get(k+1).toLowerCase().charAt(0);
                    if(endList==end && startList==start) {
                        list.add(k+1,words[i]);
                        words[i]="";
                        i=-1;
                        break;
                    }
                }
            }
        }
        if(list.size()==0) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList).append(" ");
        return sb;
    }
}