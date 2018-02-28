package com.javarush.test.level11.lesson11.home05;

/* От школьника к рабству
Написать четыре класса: Schoolboy(школьник), Student(студент), Worker(Сотрудник), Slave (Раб)
Унаследовать студента от школьника, сотрудника от студента, раба от сотрудника.
*/

class Solution {

  class Schoolboy {

  }

  class Student extends Schoolboy {

  }

  class Worker extends Student {

  }

  private class Slave extends Worker {

  }

}
