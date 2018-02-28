package com.javarush.test.level17.lesson04.task01;

import java.util.ArrayList;
import java.util.List;

/* Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized
*/

class Solution {

  static class Note {

    final List<String> notes = new ArrayList<>();

    public void addNote(int index, String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
      synchronized (notes) {
        notes.add(index, note);
      }

      System.out.println("Уже добавлена заметка [" + note + "]");
    }

    public void removeNote(int index) {
      System.out.println("Сейчас будет удалена заметка с позиции " + index);
      String note;
      synchronized (notes) {
        note = notes.remove(index);
      }
      System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }
  }
}
