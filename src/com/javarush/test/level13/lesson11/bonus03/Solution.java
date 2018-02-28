package com.javarush.test.level13.lesson11.bonus03;

/* Битва роботов
1. Разобраться в том, что тут написано.
2. http://ragecollection.com/img/ragefaces/rage-guy.png
3. Смириться со своей участью и продолжить разбираться в коде.
4. ...
5. Порадоваться, что мы все поняли.

6. Изменить код согласно новой архитектуре и добавить новую логику:
6.1. Сделать класс AbstractRobot абстрактным, вынести логику атаки и защиты из Robot в AbstractRobot.
6.2. Отредактировать класс Robot учитывая AbstractRobot.
6.3. Расширить класс BodyPart новой частью тела "грудь".
6.4. Добавить новую часть тела в реализацию интерфейсов Attackable и Defensable (в классе AbstractRobot).

7. http://ragecollection.com/img/ragefaces/fuck-yeah.png
*/

class Solution {

  public static void main(String[] args) {
    Robot amigo = new Robot("Амиго");
    Robot enemy = new Robot("Сгибальщик-02");

    doMove(amigo, enemy);
    doMove(amigo, enemy);
    doMove(enemy, amigo);
    doMove(amigo, enemy);
    doMove(enemy, amigo);
    doMove(amigo, enemy);
    doMove(enemy, amigo);
    doMove(amigo, enemy);
  }

  private static void doMove(Robot robotFirst, Robot robotScond) {
    BodyPart attacked = robotFirst.attack();
    BodyPart defenced = robotFirst.defense();
    System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
        robotFirst.getName(), robotScond.getName(), attacked, defenced));
  }
}
