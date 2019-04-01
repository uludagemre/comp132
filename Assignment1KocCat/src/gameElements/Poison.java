package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import gui.GameBoard;

public class Poison extends Food implements Drawable,Runnable{



	public Poison(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, age,board);
	}

	@Override
	public void draw(Graphics g) {
		if(super.isAlive()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.yellow);
			g2d.fillRect(getX(),getY(),30,30);
		}
	}




}
