package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import gui.GameBoard;

public class Fruit extends Food implements Drawable,Runnable{

	int radius = 30;

	// TODO Auto-generated constructor stub
	public Fruit(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, age,board);
		// TODO Auto-generated constructor stub
		System.out.println("This is x :"+getX()+" y: "+getY());
	}

	public void draw(Graphics g) {
		
		
		if(super.isAlive()) {
		Graphics2D g2d = (Graphics2D) g;
	      g2d.setColor(Color.blue);
	      g2d.fillOval(getX(),getY(),30,30);
		}

	}
}
