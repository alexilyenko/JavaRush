package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/


import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static final Map<String, String> countries = new HashMap<>();

  static {
    countries.put("UA", "Ukraine");
    countries.put("RU", "Russia");
    countries.put("CA", "Canada");
  }

  public static void main(String[] args) {
    IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(new IncomeData() {
      @Override
      public String getCountryCode() {
        return "RU";
      }

      @Override
      public String getCompany() {
        return "JavaRush Ltd.";
      }

      @Override
      public String getContactFirstName() {
        return "Ivan";
      }

      @Override
      public String getContactLastName() {
        return "Ivanov";
      }

      @Override
      public int getCountryPhoneCode() {
        return 38;
      }

      @Override
      public int getPhoneNumber() {
        return 501234567;
      }
    });

    System.out.println(incomeDataAdapter.getName());
    System.out.println(incomeDataAdapter.getPhoneNumber());
    System.out.println(incomeDataAdapter.getCompanyName());
    System.out.println(incomeDataAdapter.getCountryName());
  }

  @SuppressWarnings("SameReturnValue")
  interface IncomeData {

    String getCountryCode();        //example UA

    String getCompany();            //example JavaRush Ltd.

    String getContactFirstName();   //example Ivan

    String getContactLastName();    //example Ivanov

    int getCountryPhoneCode();      //example 38

    int getPhoneNumber();           //example 501234567
  }

  interface Customer {

    String getCompanyName();        //example JavaRush Ltd.

    String getCountryName();        //example Ukraine
  }

  interface Contact {

    String getName();               //example Ivanov, Ivan

    String getPhoneNumber();        //example +38(050)123-45-67
  }

  public static class IncomeDataAdapter implements Customer, Contact {

    final IncomeData incomeData;

    IncomeDataAdapter(IncomeData incomeData) {
      this.incomeData = incomeData;
    }

    @Override
    public String getName() {
      return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
    }

    @Override
    public String getPhoneNumber() {
      String phoneNumber = this.incomeData.getPhoneNumber() + "";
      StringBuilder nulls = new StringBuilder();
      if (phoneNumber.length() < 10) {
        for (int i = 0; i < (10 - phoneNumber.length()); i++) {
          nulls.append("0");
        }
      }
      phoneNumber = nulls + phoneNumber;
      String firstPart = phoneNumber.substring(0, 3);
      String secondPart = phoneNumber.substring(3, 6);
      String thirdPart = phoneNumber.substring(6, 8);
      String fourthPart = phoneNumber.substring(8);
      return "+" + this.incomeData.getCountryPhoneCode() + "(" + firstPart + ")" + secondPart + "-"
          + thirdPart + "-" + fourthPart;
    }

    @Override
    public String getCompanyName() {
      return this.incomeData.getCompany();
    }

    @Override
    public String getCountryName() {
      return countries.get(this.incomeData.getCountryCode());
    }
  }
}