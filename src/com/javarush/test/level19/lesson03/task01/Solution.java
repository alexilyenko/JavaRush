package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {

  public static void main(String[] args) {
    ATable aTable = new ATable() {
      @Override
      public String getCurrentUserName() {
        return "Amigo";
      }

      @Override
      public String getTableName() {
        return "DashboardTable";
      }
    };

    BTable table = new TableAdapter(aTable);
    System.out.println(table.getHeaderText());
  }

  @SuppressWarnings("SameReturnValue")
  interface ATable {

    String getCurrentUserName();

    String getTableName();
  }

  interface BTable {

    String getHeaderText();
  }

  public static class TableAdapter implements BTable {

    final ATable table;

    TableAdapter(ATable table) {
      this.table = table;
    }

    @Override
    public String getHeaderText() {
      return "[" + this.table.getCurrentUserName() + "] : " + this.table.getTableName();
    }
  }
}