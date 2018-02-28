package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

  private static final Map<String, String> countries = new HashMap<>();

  static {
    countries.put("Ukraine", "UA");
    countries.put("Russia", "RU");
    countries.put("Canada", "CA");
  }

  interface RowItem {

    String getCountryCode();        //example UA

    String getCompany();            //example JavaRush Ltd.

    String getContactFirstName();   //example Ivan

    String getContactLastName();    //example Ivanov

    String getDialString();         //example callto://+380501234567
  }

  interface Customer {

    String getCompanyName();        //example JavaRush Ltd.

    String getCountryName();        //example Ukraine
  }

  interface Contact {

    String getName();               //example Ivanov, Ivan

    String getPhoneNumber();        //example +38(050)123-45-67
  }

  public static class DataAdapter implements RowItem {

    final Customer customer;
    final Contact contact;

    public DataAdapter(Customer customer, Contact contact) {
      this.customer = customer;
      this.contact = contact;
    }

    @Override
    public String getCountryCode() {
      return countries.get(this.customer.getCountryName());
    }

    @Override
    public String getCompany() {
      return this.customer.getCompanyName();
    }

    @Override
    public String getContactFirstName() {
      String[] nameArray = this.contact.getName().split(", ");
      return nameArray[1];
    }

    @Override
    public String getContactLastName() {
      String[] nameArray = this.contact.getName().split(", ");
      return nameArray[0];
    }

    @Override
    public String getDialString() {
      String phoneNumber = this.contact.getPhoneNumber();
      String rowDigits = phoneNumber.replaceAll("[^+0-9]", "");
      System.out.println(rowDigits);
      return "callto://" + rowDigits;
    }
  }
}