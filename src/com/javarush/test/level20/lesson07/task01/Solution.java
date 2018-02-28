package com.javarush.test.level20.lesson07.task01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
class Solution {

  static class Apartment implements Externalizable {

    private String address;
    private int year;

    /**
     * Mandatory public no-arg constructor.
     */
    public Apartment() {
      super();
    }

    public Apartment(String adr, int y) {
      address = adr;
      year = y;
    }

    /**
     * Prints out the fields. used for testing!
     */
    public String toString() {
      return ("Address: " + address + "\n" + "Year: " + year);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeObject(this.address);
      out.writeInt(this.year);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      this.address = (String) in.readObject();
      this.year = in.readInt();
    }
  }
}
