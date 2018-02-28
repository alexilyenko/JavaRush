package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/


class Solution {

  private static final List<Person> allPeople = new ArrayList<>();

  static {
    allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
    allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
  }

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    switch (args[0]) {
      case "-c":
        synchronized (Solution.class) {
          for (int i = 1; i < args.length; i = i + 3) {
            if (args[i + 1].equals("м")) {
              Person m = Person.createMale(args[i], sdf1.parse(args[i + 2]));
              allPeople.add(m);
              System.out.println(allPeople.indexOf(m));
            } else if (args[i + 1].equals("ж")) {
              Person w = Person.createFemale(args[i], sdf1.parse(args[i + 2]));
              allPeople.add(w);
              System.out.println(allPeople.indexOf(w));
            }
          }
        }
        break;
      case "-u":
        synchronized (Solution.class) {
          for (int i = 1; i < args.length; i = i + 4) {
            int id = Integer.parseInt(args[i]);
            allPeople.get(id).setName(args[i + 1]);
            allPeople.get(id).setBirthDay(sdf1.parse(args[i + 3]));
            if (args[i + 2].equals("м")) {
              allPeople.get(id).setSex(Sex.MALE);
            } else if (args[i + 2].equals("ж")) {
              allPeople.get(id).setSex(Sex.FEMALE);
            }
          }
        }
        break;
      case "-d":
        synchronized (Solution.class) {
          for (int i = 1; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setSex(null);
          }
        }
        break;
      case "-i":
        synchronized (Solution.class) {
          for (int i = 1; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);
            System.out.print(allPeople.get(id).getName() + " ");
            if (allPeople.get(id).getSex().equals(Sex.MALE)) {
              System.out.print("м ");
            } else if (allPeople.get(id).getSex().equals(Sex.FEMALE)) {
              System.out.print("ж ");
            }
            System.out.print(sdf2.format(allPeople.get(id).getBirthDay()) + " ");
          }
        }
        break;
    }
  }
}