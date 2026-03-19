package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * driver adapter to drawer for custom lines.
 */
public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver{
	private int startX = 0, startY = 0;
    public enum lineTypeEnum {BASIC, DOTTED, SPECIAL};
    private lineTypeEnum LineType;


	public LineDrawerAdapter(lineTypeEnum lineType) {
		super();
        this.LineType = lineType;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = null;
        switch(this.LineType){
            case BASIC:
                line = LineFactory.getBasicLine();
                break;
            case DOTTED:
                line = LineFactory.getDottedLine();
                break;
            case SPECIAL:
                line = LineFactory.getSpecialLine();
                break;
        }

		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
        this.startX = x;
        this.startY = y;

		DrawerFeature.getDrawerController().drawLine(line);
	}

	@Override
	public String toString() {
        switch(this.LineType){
            case BASIC:
                return "Basic Line";
            case DOTTED:
                return "Dotted Line";
            case SPECIAL:
                return "Special Line";
        }
		return "Line";
	}
}
