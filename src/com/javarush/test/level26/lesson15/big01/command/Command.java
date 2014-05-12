package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


interface Command
{
    void execute() throws InterruptOperationException;
}
