package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import gui.GameBoard;

public class Fruit extends Food {

		// TODO Auto-generated constructor stub
	public Fruit(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, age,board);
		// TODO Auto-generated constructor stub
	}

	public void drawItem(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Shape recht = new Rectangle(getX(), getY(), 50, 50);
		Color color = Color.blue;
		g2.setColor(color);
		g2.fill(recht);
		
		
		
		//		g2.drawRect(getX(), getY(), 40, 40);
//		g2.fillRect(getY(), getY(), 40, 40);;
//		g2.setPaint(Color.blue);
	}
}
