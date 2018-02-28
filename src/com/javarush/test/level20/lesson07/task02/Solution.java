package com.javarush.test.level20.lesson07.task02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
class Solution {

  private static final String greeting = "Hello world";

  /**
   * OutputToConsole is the inner base class for improving your attentiveness.
   * An OutputToConsole object encapsulates the information needed
   * for the displaying [greeting] variable to the console by character.
   *
   * @author JavaRush
   */
  static class OutputToConsole implements Externalizable {

    private int i = 8;

    /**
     * Class constructor specifying fake private field [i].
     */

    public OutputToConsole() {
    }

    public OutputToConsole(int ii) {
      this.i = ii;
    }

    /**
     * @param out A stream for an externalization
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeInt(i);
    }

    /**
     * @param in A stream for a de-externalization
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException {
      i = in.readInt();
    }

    /**
     * Outputs to the console a static field of Solution class [greeting].
     * Has to use [charAt] method of String class
     */
    public void outputToConsole(int ii) {
      for (int i = 0; i < greeting.length(); i++) {
        System.out.write(greeting.charAt(i));
      }
    }
  }
}
