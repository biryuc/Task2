package com.company;




////import calculator.Commands.CalcCommand;
//import calculator.Commands.CommandExecuteException;
//import calculator.Main.Context;

import java.util.EmptyStackException;
import java.util.List;

public class Div implements CalcCommand{
    private static final double EPSILON = 1e-9;

    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException {
        double a;
        double b;
        try {
            b = context.popFromStack();
            a = context.popFromStack();
        } catch (EmptyStackException e){
            throw  new CommandExecuteException("Cannot execute command because stack is empty ", e);
        }
        if(Math.abs(a)<EPSILON){
            throw new CommandExecuteException("Second argument div command must be not zero");
        }
        double result = a/b;
        context.pushToStack(result);
    }
}
