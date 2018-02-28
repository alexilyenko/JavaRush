package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.ResourceBundle;

/**
 * Created by Alex on 29.04.2014.
 */
class ExitCommand implements Command {

  private final ResourceBundle res = ResourceBundle
      .getBundle(CashMachine.RESOURCE_PATH + "exit_en");

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

    if (ConsoleHelper.readString().equals(res.getString("yes"))) {
      ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
  }
}
