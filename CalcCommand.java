package com.company;


import java.util.List;

import java.util.List;

public interface CalcCommand {
    void execute(Context context, List<String> myArgs) throws CommandExecuteException;
}
