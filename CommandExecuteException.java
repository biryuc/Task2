package com.company;

//package ru.nsu.ccfit.terekhov.calculator.Commands;

public class CommandExecuteException extends Exception{

    public CommandExecuteException(){
        super(); //To change body of overridden methods use File | Settings | File Templates.
    }

    public CommandExecuteException(String message){
        super(message); //To change body of overridden methods use File | Settings | File Templates.
    }

    public CommandExecuteException(String message, Throwable cause){
        super(message, cause);
    }

    public CommandExecuteException(Throwable cause){
        super(cause); //To change body of overridden methods use File | Settings | File Templates.
    }
}
