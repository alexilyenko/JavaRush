package com.javarush.test.level17.lesson02.task01;

import java.util.ArrayList;
import java.util.List;

/* Заметки
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread, которая в методе run 1000 раз (index = 0-999) сделает следующие
действия:
2.1. используя метод addNote добавит заметку с именем [getName() + "-Note" + index], например, при index=4
"Thread-0-Note4"
2.2. используя метод removeNote удалит заметку
2.3. в качестве первого параметра в removeNote передай имя нити - метод getName()
*/

class Solution {

  public static void main(String[] args) {
    NoteThread nt = new NoteThread();
  }

  static class NoteThread extends Thread {

    NoteThread() {
      this.start();
    }

    public void run() {
      for (int i = 0; i < 1000; i++) {
        Note.addNote(this.getName() + "-Note" + i);
        Note.removeNote(this.getName());
      }
    }
  }

  static class Note {

    static final List<String> notes = new ArrayList<>();

    static void addNote(String note) {
      notes.add(0, note);
    }

    static void removeNote(String threadName) {
      String note = notes.remove(0);
      if (note == null) {
        System.out.println("Другая нить удалила нашу заметку");
      } else if (!note.startsWith(threadName)) {
        System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
      }
    }
  }
}
