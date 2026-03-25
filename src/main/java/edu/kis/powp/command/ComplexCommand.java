package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand{

    ArrayList<DriverCommand> commands;

    public ComplexCommand(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand newCommand){
        this.commands.add(newCommand);
    }

    public void execute(){
        for(DriverCommand command : this.commands){
            command.execute();
        }
    }

}
