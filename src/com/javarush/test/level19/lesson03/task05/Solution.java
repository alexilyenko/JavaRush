package com.javarush.test.level19.lesson03.task05;

import com.sun.rowset.internal.Row;

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
    private static Map<String,String> countries = new HashMap<String,String>();
    static  {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }

    public static class DataAdapter implements RowItem{
        Customer customer;
        Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            return countries.get(this.customer.getCountryName());
        }

        @Override
        public String getCompany()
        {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] nameArray = this.contact.getName().split(", ");
            return nameArray[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] nameArray = this.contact.getName().split(", ");
            return nameArray[0];
        }

        @Override
        public String getDialString()
        {
            String phoneNumber = this.contact.getPhoneNumber();
            String rowDigits = phoneNumber.replaceAll("[^+0-9]", "");
            System.out.println(rowDigits);
            return "callto://"+rowDigits;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}