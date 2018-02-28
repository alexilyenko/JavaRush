package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CommandExecutor {

  private static final Map<Operation, Command> map = new HashMap<>();

  static {
    map.put(Operation.LOGIN, new LoginCommand());
    map.put(Operation.INFO, new InfoCommand());
    map.put(Operation.DEPOSIT, new DepositCommand());
    map.put(Operation.WITHDRAW, new WithdrawCommand());
    map.put(Operation.EXIT, new ExitCommand());
  }

  public CommandExecutor() {
  }

  public static void execute(Operation operation) throws InterruptOperationException {
    map.get(operation).execute();
  }

}
