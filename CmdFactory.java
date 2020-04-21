package com.company;



//package ru.nsu.ccfit.terekhov.calculator.Main;

//import ru.nsu.ccfit.terekhov.calculator.Commands.CalcCommand;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.util.NoSuchElementException;

import java.util.Properties;

import java.util.TreeMap;

//import calculator.Commands.CalcCommand;


import java.lang.reflect.InvocationTargetException;

public class CmdFactory {
    private static Properties properties = null;
    private static TreeMap<String,Class> classes = null;

    static {
        classes = new TreeMap<String, Class>();
        InputStream conformacesAsStream = null;
        try {
            conformacesAsStream = new FileInputStream("CmdFactory.properties");
            properties = new Properties();
            properties.load(conformacesAsStream);
        } catch (IOException e){
            System.out.println("IOException occurred in CommandsFactory.properties " + e.getLocalizedMessage());
        } finally {
            try {
                if (null != conformacesAsStream){
                    conformacesAsStream.close();
                }
            }catch (IOException e){
                System.out.println("IOException: " + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Returns CalcCommand command that names cmdName.
     * @param cmdName name of command.
     * @return CalcCommand object <code>command</code> if it exists.
     */
    public static CalcCommand getCommand(String cmdName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CalcCommand command;
        Class<?> cmdClass;

        String commandUp = cmdName.toUpperCase();
        String key = properties.getProperty(commandUp);
        if(null==key){
            throw new NoSuchElementException("Invalid command request: " + commandUp);
        }
        if (!classes.containsKey(key)){
            cmdClass = Class.forName(key);
            classes.put(cmdName,cmdClass);
        } else {
            cmdClass = classes.get(cmdName);
        }
        command = (CalcCommand) cmdClass.getDeclaredConstructor().newInstance();
        return command;
    }
}
