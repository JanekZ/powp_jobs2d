package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FiguresFactory {

    private FiguresFactory(){}

    public ComplexCommand constructSquare(Job2dDriver driver, int side){
        ComplexCommand square = new ComplexCommand();
        int x = 0;
        int y = 0;
        square.addCommand(new SetPositionCommand(driver, x, y));
        square.addCommand(new OperateToCommand(driver, x+side, y));
        square.addCommand(new OperateToCommand(driver, x+side, y+side));
        square.addCommand(new OperateToCommand(driver, x, y+side));
        square.addCommand(new OperateToCommand(driver, x, y));
        
        return square;
    }
}
