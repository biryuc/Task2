package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Stack;

public class CmdFactory{
    //fabric pattern
    HashMap<String, Commands> CommandsMap = new HashMap<String, Commands>();

    public void parsing(Stack stack, String commandName){
        try {
            //fabric:
            Commands command = CommandsMap.get(commandName);
            if(command == null){
                Class<?> cl = Class.forName(commandName);
                Constructor<?> con = cl.getDeclaredConstructor();
                command = (Commands) con.newInstance();
                CommandsMap.put(commandName, command);
            }
            command.ToDo(stack);
        } catch (InvocationTargetException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}