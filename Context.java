package com.company;


import java.util.*;

public class Context {
    private LinkedList<Double> calcStack = new LinkedList<Double>();
    private TreeMap<String,Double> constants = new TreeMap<String, Double>();

    public double getConstants(String var) throws NoSuchElementException{
        if(!constants.containsKey(var)){
            throw new NoSuchElementException("Stack doesn't contain Const of" + var);
        }
        return constants.get(var);
    }

    public void setConstants(String var, Double value){
        constants.put(var, value);
    }

    public void pushToStack(double value){
        calcStack.push(value);
    }

    public double popFromStack() throws EmptyStackException{
        return calcStack.pop();
    }

    public double peekAtStack() throws EmptyStackException{
        return calcStack.peek();
    }
}