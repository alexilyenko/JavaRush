package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot implements Attackable, Defensable {

  private static int hitCount;

  public BodyPart attack() {
    BodyPart attackedBodyPart = null;
    hitCount = hitCount + 1;

    switch (hitCount) {
      case 1:
        attackedBodyPart = BodyPart.ARM;
        break;
      case 2:
        attackedBodyPart = BodyPart.HEAD;
        break;
      case 3:
        hitCount = 0;
        attackedBodyPart = BodyPart.LEG;
        break;
      case 4:
        attackedBodyPart = BodyPart.CHEST;
        break;
    }
    return attackedBodyPart;
  }

  public BodyPart defense() {
    BodyPart defencedBodyPart = null;
    hitCount = hitCount + 1;

    switch (hitCount) {
      case 1:
        defencedBodyPart = BodyPart.HEAD;
        break;
      case 2:
        defencedBodyPart = BodyPart.LEG;
        break;
      case 3:
        hitCount = 0;
        defencedBodyPart = BodyPart.ARM;
        break;
      case 4:
        defencedBodyPart = BodyPart.CHEST;
        break;
    }
    return defencedBodyPart;
  }


}
