package gameElements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

import gui.GameBoard;

public class Player extends Item {

	private String name;
	private String surName;
	private int score;

	public Player(int x, int y, boolean alive, String iconPath, String name, String surName,
			int score) {
		super(x, y, alive, iconPath,null);
		this.name = name;
		this.surName = surName;
		this.score = score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return this.score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void move(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_left.png");

			} catch (FileNotFoundException exception) {
				System.out.println("No image path found");
			}
			if(getX()>210) {
				goLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_down.png");

			} catch (FileNotFoundException exception) {
				System.out.println("No image path found");
			}
			if(getY()<500) {
				goDown();
			}
		}	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			try {
				setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_up.png");

			} catch (FileNotFoundException exception) {
				System.out.println("No image path found");
			}
			if(getY()>0) {
				goUp();

			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png");

			} catch (FileNotFoundException exception) {
				System.out.println("No image path found");
			}
			if(getX()<700) {
				goRight();
			}
			
		}
	}
}


