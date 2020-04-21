package com.company;





import java.util.EmptyStackException;

import java.util.List;

import java.util.List;
import java.util.EmptyStackException;

public class Print implements CalcCommand{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException {
        try{
            double a=context.peekAtStack();
            System.out.println("Result" + " " + a);
        } catch(EmptyStackException e){
            throw new CommandExecuteException("Cannot execute command because stack is empty", e);
        }
    }
}
