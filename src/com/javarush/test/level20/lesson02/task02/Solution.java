package com.javarush.test.level20.lesson02.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
class Solution {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    try {
      File fileName = new File("d:/1.txt");
      OutputStream outputStream = new FileOutputStream(fileName);
      InputStream inputStream = new FileInputStream(fileName);

      JavaRush javaRush = new JavaRush();

      User user1 = new User();
      user1.setFirstName("Alex");
      user1.setLastName("Ilyenko");
      user1.setBirthDate(new Date(1989, 3, 15));
      user1.setMale(true);
      user1.setCountry(User.Country.UKRAINE);

      User user2 = new User();
      user2.setFirstName("Bart");
      user2.setBirthDate(new Date(1989, 3, 15));
      user2.setCountry(User.Country.OTHER);

      User user3 = new User();
      user3.setLastName("Jolie");
      user3.setMale(false);

      javaRush.users.add(user1);
      javaRush.users.add(user2);
      javaRush.users.add(user3);

      javaRush.save(outputStream);
      outputStream.flush();

      JavaRush loadedObject = new JavaRush();
      loadedObject.load(inputStream);

      System.out.println(javaRush.users.get(0).getCountry().getDisplayedName());
      System.out.println(loadedObject.users.get(0).getCountry().getDisplayedName());

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

  static class JavaRush {

    final List<User> users = new ArrayList<>();

    @SuppressWarnings("deprecation")
    void save(OutputStream outputStream) {
      PrintWriter printWriter = new PrintWriter(outputStream);
      printWriter.println("@");
      if (this.users.size() > 0) {
        for (User current : this.users) {
          StringBuilder sb = new StringBuilder();
          String hasFirstName = (current.getFirstName() != null) ? "yes" : "no";
          if ("yes".equals(hasFirstName)) {
            sb.append(current.getFirstName()).append(" ");
          } else {
            sb.append("- ");
          }

          String hasLastName = (current.getLastName() != null) ? "yes" : "no";
          if ("yes".equals(hasLastName)) {
            sb.append(current.getLastName()).append(" ");
          } else {
            sb.append("- ");
          }

          String hasBirthDate = (current.getBirthDate() != null) ? "yes" : "no";
          if ("yes".equals(hasBirthDate)) {
            sb.append(current.getBirthDate().getYear()).append(" ")
                .append(current.getBirthDate().getMonth()).append(" ")
                .append(current.getBirthDate().getDate()).append(" ");
          } else {
            sb.append("- - - ");
          }

          if (current.isMale()) {
            sb.append(true).append(" ");
          } else {
            sb.append(false).append(" ");
          }

          String hasCountry = (current.getCountry() != null) ? "yes" : "no";
          if ("yes".equals(hasCountry)) {
            sb.append(current.getCountry().getDisplayedName()).append(" ");
          } else {
            sb.append("- ");
          }
          printWriter.println(sb.toString());
        }
      }
      printWriter.close();
    }

    @SuppressWarnings("deprecation")
    void load(InputStream inputStream) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();
      if (line.equals("@")) {
        line = reader.readLine();
      }
      while (line != null) {
        User user = new User();
        String[] lineArray = line.split(" ");
        if (!"-".equals(lineArray[0])) {
          user.setFirstName(lineArray[0]);
        }
        if (!"-".equals(lineArray[1])) {
          user.setLastName(lineArray[1]);
        }
        if (!"-".equals(lineArray[2])) {
          user.setBirthDate(new Date(Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]),
              Integer.parseInt(lineArray[4])));
        }
        user.setMale(Boolean.parseBoolean(lineArray[5]));
        if (!"-".equals(lineArray[6])) {
          User.Country country;
          switch (lineArray[6]) {
            case "Ukraine":
              country = User.Country.UKRAINE;
              break;
            case "Russia":
              country = User.Country.RUSSIA;
              break;
            default:
              country = User.Country.OTHER;
              break;
          }
          user.setCountry(country);
        }
        this.users.add(user);
        line = reader.readLine();
        if ("@".equals(line)) {
          break;
        }
      }
      reader.close();
    }
  }
}
