package com.company;



//import calculator.Commands.CalcCommand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.*;

public class Calculator {
    private final static Context context = new Context();

    public static void main(String args[]){
        printCommands();
        Scanner scanner = getScanner(args);
        assert null !=scanner;
        while(scanner.hasNextLine()){
            String commandStr = scanner.nextLine();
            commandStr = clearString(commandStr);
            if(isInsignificantCommand(commandStr)){
                continue;
            }
            executeCommand(commandStr);
        }
        scanner.close();

    }

    private static Scanner getScanner(String[] args){
        assert null !=args;
        Scanner scanner = null;
        if(1==args.length){
            String fileName = args[0];
            try{
                InputStream inputStream = new FileInputStream(fileName);
                scanner = new Scanner(inputStream);
            } catch (FileNotFoundException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }
        } else{
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    private static void executeCommand(String commandStr){
        String cmd[]=commandStr.split(" ");
        List<String> cmdArguments = createCmdArguments(cmd);
        try{
            CalcCommand command = CmdFactory.getCommand(cmd[0]);
            command.execute(context, cmdArguments);
        } catch (Throwable e){
            System.err.println("Error execute command: " + e.getLocalizedMessage());
        }
    }

    private static List<String> createCmdArguments(String[] cmd){
        assert null !=cmd;
        return new ArrayList<String>(Arrays.asList(cmd).subList(1, cmd.length));
    }
    private static String clearString(String str){
        return str.trim().replaceAll("\\s+", " ");
    }

    private static boolean isInsignificantCommand(String command){
        return command.equals("") || command.startsWith("#");
    }

    private static void printCommands(){
        String str = "Commands Reference\n"+
                "1) POP param, PUSH param;\n"+
                "2) Arithmetic operations:\n"+
                "+. -, *, /, sqrt\n"+
                "3)Print\n"+
                "DEFINE parameterName parameterValue\n";
        System.out.println(str);
    }
}
