package com.javarush.test.level17.lesson10.home05;

/* Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов
*/

class Solution {

  private static final java.io.ObjectStreamField[] serialPersistentFields =
      {
          new java.io.ObjectStreamField("value", char[].class),
          new java.io.ObjectStreamField("count", Integer.TYPE),
          new java.io.ObjectStreamField("shared", Boolean.TYPE),
      };
  private char[] value;
  private int count;

  private Solution append(CharSequence s) {
    if (s == null) {
      s = "null";
      if (s instanceof String) {
        return this.append(s);
      }
      if (s instanceof Solution) {
        return this.appendThis((Solution) s);
      }
    }
    return this.append(s);
  }

  private synchronized Solution appendThis(Solution s) {
    return this;
  }

  private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
    java.io.ObjectOutputStream.PutField fields = s.putFields();
    fields.put("value", value);
    fields.put("count", count);
    fields.put("shared", false);
    s.writeFields();
  }

  private void readObject(java.io.ObjectInputStream s)
      throws java.io.IOException, ClassNotFoundException {
    java.io.ObjectInputStream.GetField fields = s.readFields();
    value = (char[]) fields.get("value", null);
    count = fields.get("count", 0);
  }
}
