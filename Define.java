package com.company;

//package ru.nsu.ccfit.terekhov.calculator.Commands;

//import ru.nsu.ccfit.terekhov.calculator.Main.Context;

import java.util.EmptyStackException;

import java.util.List;

import java.util.EmptyStackException;
import java.util.List;

public class Define  implements CalcCommand{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException {
        if(myArgs.size()<2){
            throw new CommandExecuteException("You may use DEFINE as \"DEFINE paramName paramValue\"!");
        }
        String constValueStr = null;
        try{
            String constName = myArgs.get(0);
            constValueStr=myArgs.get(1);
            double constValue = Double.parseDouble(constValueStr);
            context.setConstants(constName, constValue);
        } catch(NumberFormatException e){
            throw new CommandExecuteException(constValueStr + "is not a number", e);
        } catch (EmptyStackException e){
            throw new CommandExecuteException("Cannot execute command because stack is empty ", e);
        }
    }
}
