package com.javarush.test.level21.lesson10.task02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/* Освобождаем ресурсы
Реализуйте метод finalize, подумайте, что именно в нем должно быть.
Отрефакторите метод getUsers в соответствии с java7 try-with-resources.
Допускаются только текстовые коментарии.
*/
class Solution {

  private final Connection connection;

  public Solution(Connection connection) {
    this.connection = connection;
  }

  public List<User> getUsers() {
    String query = "SELECT ID, DISPLAYED_NAME, LEVEL, LESSON FROM USER";

    List<User> result = new LinkedList<>();

    try (
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query)
    ) {
      while (rs.next()) {
        int id = rs.getInt("ID");
        String name = rs.getString("DISPLAYED_NAME");
        int level = rs.getInt("LEVEL");
        int lesson = rs.getInt("LESSON");

        result.add(new User(id, name, level, lesson));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }

  @Override
  protected void finalize() throws Throwable {
    connection.close();
  }

  static class User {

    private final int id;
    private final String name;
    private final int level;
    private final int lesson;

    User(int id, String name, int level, int lesson) {
      this.id = id;
      this.name = name;
      this.level = level;
      this.lesson = lesson;
    }

    @Override
    public String toString() {
      return "User{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", level=" + level +
          ", lesson=" + lesson +
          '}';
    }
  }
}
