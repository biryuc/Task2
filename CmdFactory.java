package com.company;





import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.NoSuchElementException;

import java.util.Properties;

import java.util.TreeMap;




import java.lang.reflect.InvocationTargetException;
import java.util.logging.Handler;

public class CmdFactory {
    private static Properties properties = null;
    private static TreeMap<String,Constructor> classes = null;

    static {
        classes = new TreeMap<String, Constructor>();
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
        cmdClass = Class.forName(key);
        //////////////////////////////////////////////
        HashMap<String, Handler> handler = new HashMap<>();
        String comm = properties.getProperty(commandUp);
        Handler h = handler.get(comm);

        if (null == h) {


                Constructor<?> constructor = cmdClass.getConstructor();

                h = (Handler) constructor.newInstance();
                handler.put(comm, h);

        }


        }
        h.todo;
        ///////////////////////////////////////////////

        //return command;
    }
}