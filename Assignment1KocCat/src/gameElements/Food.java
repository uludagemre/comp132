package gameElements;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.GameBoard;

public class Food extends Item implements Runnable {

	private int age;

	public Food(int x, int y, boolean alive, String iconPath, int age, GameBoard board) {
		super(x, y, alive, iconPath,board);
		this.age = age;
	}

	public void grow() {
		setAge(getAge()+1);
	}


	public void checkConsumed() {
		if((getBoard().getPlayer().getX() == super.getX())&&(getBoard().getPlayer().getY() == super.getY())) {
			super.setShouldDrawn(false);
//			System.out.println("Checked");
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
		int count = 0;
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"The thread is interrupted!");
			}
//			checkConsumed();
//			count++;
//			if(count%10==0) grow();
		}
	}
}
