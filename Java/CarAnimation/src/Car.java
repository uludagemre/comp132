
import java.awt.*;
import java.sql.Time;
import java.time.*;

import javax.swing.*;
import java.util.*;

public class Car extends JPanel {

	private int xCoordinate;
	private int yCoordinate;
	

	public Car() {
		xCoordinate = 0;
		yCoordinate = 150;
	}

	public void move() {
		
		repaint();
	}

	protected void paintComponent(Graphics g) {
		if (xCoordinate > getWidth()) xCoordinate = 5;
		xCoordinate+=5;
		super.paintComponent(g);
		g.drawRect(xCoordinate, yCoordinate, 100, 100);
	

	}


}



