package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import gui.GameBoard;

public class Poison extends Food{

	public Poison(int x, int y, boolean alive, String iconPath, int age, GameBoard board,int number) {
		super(x, y, alive, iconPath, age,board,number);
	}

	@Override
	public void drawItem(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Shape rect = new Rectangle(getX(), getY(), 60, 60);
		g2.draw(rect);
		g2.setPaint(Color.yellow);
	}
	
}
