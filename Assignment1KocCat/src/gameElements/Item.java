package gameElements;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import gui.GameBoard;

public class Item implements Drawable {
	
//	private int x;
//	private int y;
	private ArrayList<Coordinate> items;
	private boolean alive;
	private String iconPath;
	private GameBoard board;
	private boolean shouldDrawn =true; 
	
	
	public void setShouldDrawn(boolean shouldDrawn) {
		this.shouldDrawn = shouldDrawn;
	}


	public Item(ArrayList<Coordinate> coordinates, boolean alive, String iconPath ,GameBoard board) {
		
		this.items = items;
		this.alive = alive;
		this.iconPath = iconPath;
		this.board = board;
		
	}


	public void setIconPath(String iconPath) throws FileNotFoundException {
		if(iconPath == null) {
			throw new FileNotFoundException("No image found");
		}else {
			this.iconPath = iconPath;	
		}
	}
	
	
	public String getIconPath() {
		return this.iconPath;
	}
	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}
	
	public ArrayList<Coordinate> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Coordinate> items) {
		Coordinate it = (Coordinate) items.iterator();
		while(((Iterator<Coordinate>) it).hasNext()) {
			this.items.add(it);
		}
	}
	
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
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
		if(shouldDrawn) {
			ImageIcon image = new ImageIcon(getIconPath());
			g.drawImage(image.getImage(), getX(), getY(), null);	
		}
		
	}
	
}
