package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
class Solution {

  static final class Constants {

    static final String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
    static final String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
    static final String USER_IS_BANNED = "User is banned.";
    static final String ACCESS_IS_DENIED = "Access is denied.";
  }

  private class ServerNotAccessibleException extends Exception {

    public ServerNotAccessibleException() {
      super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW);
    }

    public ServerNotAccessibleException(Throwable cause) {
      super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW, cause);
    }
  }

  private class UnauthorizedUserException extends Exception {

    public UnauthorizedUserException() {
      super(Constants.USER_IS_NOT_AUTHORIZED);
    }

    public UnauthorizedUserException(Throwable cause) {
      super(Constants.USER_IS_NOT_AUTHORIZED, cause);
    }
  }

  private class BannedUserException extends Exception {

    public BannedUserException() {
      super(Constants.USER_IS_BANNED);
    }

    public BannedUserException(Throwable cause) {
      super(Constants.USER_IS_BANNED, cause);
    }
  }

  private class RestrictionException extends Exception {

    public RestrictionException() {
      super(Constants.ACCESS_IS_DENIED);
    }

    public RestrictionException(Throwable cause) {
      super(Constants.ACCESS_IS_DENIED, cause);
    }
  }
}
