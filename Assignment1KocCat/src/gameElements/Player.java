package gameElements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

import gui.GameBoard;

public class Player {
	private boolean isFruitMatched ;
	private String name;
	private String surName;
	private int score;
	private GameBoard board;
	private int x;
	private int y;
	private String iconPath;
	private boolean isAlive;

	public Player(int x, int y, boolean alive, String iconPath, String name, String surName,
			int score) {
		setX(x);
		setY(y);
		this.name = name;
		this.surName = surName;
		this.score = score;
		setAlive(alive);
		setIconPath(iconPath);
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
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
			setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_left.png");
			if(getX()>210) {
				goLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_down.png");
			if(getY()<500) {
				goDown();
			}
		}	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_up.png");
			if(getY()>0) {
				goUp();

			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setIconPath("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png");
			if(getX()<700) {
				goRight();
			}
			
		}
//		System.out.println("This is your score: "+getScore());
		
	}
	public void setBoard(GameBoard board) {
		this.board = board;
	}
	public int getX() {
		return x; 
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean alive) {
		this.isAlive = alive;
	}
	public void goUp() {
		setY(getY()-board.step);
	}
	public void goDown() {
		setY(getY()+board.step);
	}
	public void goRight() {
		setX(getX()+board.step);
	}
	public void goLeft() {
		setX(getX()-board.step);
	}
	public void drawItem(Graphics g) {

		ImageIcon image = new ImageIcon(getIconPath());
		g.drawImage(image.getImage(), getX(), getY(), null);	
	}

}



