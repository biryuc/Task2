package com.company;

import java.util.EmptyStackException;

import java.util.List;

//import calculator.Commands.CalcCommand;
//import calculator.Commands.CommandExecuteException;
//import calculator.Main.Context;

import java.util.EmptyStackException;
import java.util.List;

public class Diff implements CalcCommand{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException {
        try {
            double b = context.popFromStack();
            double a =context.popFromStack();
            context.pushToStack(a-b);
        } catch (EmptyStackException e){
            throw  new CommandExecuteException("Cannot execute command because stack is empty ", e);
        }
    }
}
