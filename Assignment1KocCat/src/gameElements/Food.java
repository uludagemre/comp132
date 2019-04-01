package gameElements;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.GameBoard;

public class Food extends Item implements Runnable {

	private int age;
	private int number;
	
	public Food(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath, board);
		this.number=number;
		this.age = age;
	}

	public void grow() {
		setAge(getAge()+1);
	}


	public void checkConsumed() {
		if((getBoard().getPlayer().getX() == super.getX())&&(getBoard().getPlayer().getY() == super.getY())) {
			super.setShouldDrawn(false);

			super.getBoard().repaint();
		}
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"The thread is interrupted!");
			}
		}
	}
}
