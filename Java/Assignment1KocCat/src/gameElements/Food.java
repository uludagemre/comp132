package gameElements;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.GameBoard;

public abstract class Food extends Item implements Runnable{

	private int age;

	
	public Food(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, board);

		this.age = age;
	}

	public void grow() {
		setAge(getAge()+1);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void run() {
		long time = 0;
		while(true) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"The thread is interrupted!");
			}
			time +=10;
			if(time%10000 == 0) grow();
			doAction(); //Checks if it should be consumed
			super.getBoard().repaint();
			if(super.getBoard().getPlayer().getScore()<0 || (super.getBoard().getFruitUntilWon() == 0)) super.getBoard().endGame();
		}
	}
	
	
}
