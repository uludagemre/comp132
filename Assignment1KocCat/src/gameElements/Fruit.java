package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import gui.GameBoard;

public class Fruit extends Food implements Drawable,Runnable{

	Random rand = new Random();
	int radius = 30;

	public Fruit(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, age,board);
	
	}

	public void draw(Graphics g) {

		if(super.isAlive()) {
			if(getAge()<5) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.blue);
				g2d.fillOval(getX(),getY(),30,30);
			}else if(getAge()>=5 && getAge()<10) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.green);
				g2d.fillOval(getX(),getY(),30,30);
			}else {
				setX(GameBoard.baseX+GameBoard.step*rand.nextInt(9));
				setY(GameBoard.baseY+GameBoard.step*rand.nextInt(9));
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.blue);
				g2d.fillOval(getX(),getY(),30,30);
				setAge(1);
			}
 
		}
	}

	@Override
	public void doAction() {
		boolean matched =(getBoard().getPlayer().getX() == super.getX())&&(getBoard().getPlayer().getY() == super.getY());
		if(matched) {
			consume();
			int score = getBoard().getPlayer().getScore();
			score+=5*getAge();
			getBoard().getPlayer().setScore(score);
			getBoard().decreaseFruitUntilWon();
		}
		
	}
}
