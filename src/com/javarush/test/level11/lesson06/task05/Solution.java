package com.javarush.test.level11.lesson06.task05;

/* ИТ-компания
Написать девять классов: Worker(сотрудник), Clerk (клерк), IT (ИТ-специалист), Programmer(программист), ProjectManager(менеджер проекта), CTO(технический директор), HR(рекрутер), OfficeManager(офис-менеджер), Cleaner (уборщик).
Унаследовать программиста, менеджера проекта и технического директора от ИТ-специалиста.
Унаследовать рекрутера, уборщика и офис-менеджера от клерка.
Унаследовать клерка и ИТ-специалиста от сотрудника.
*/

class Solution {

  class Worker {

  }

  class Clerk extends Worker {

  }

  class IT extends Worker {

  }

  private class Programmer extends IT {

  }

  private class ProjectManager extends IT {

  }

  private class CTO extends IT {

  }

  private class OfficeManager extends Clerk {

  }

  private class HR extends Clerk {

  }

  private class Cleaner extends Clerk {

  }
}
