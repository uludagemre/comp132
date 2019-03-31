package gameElements;

import java.util.ArrayList;

import gui.GameBoard;

public class Game {

	private int numberOfGhost;
	private int numberOfFoods;
	private GameBoard board;
	private ArrayList<Item> items;
	private Player player;
	
	public Game (int ghost, int food,Player player) {
		setNumberOfFoods(food);
		setNumberOfGhost(ghost);
		setPlayer(player);
		for (int i = 0; i < numberOfFoods + numberOfGhost; i++) {
			//items.add();
		}
		
	}	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}

	public int getNumberOfGhost() {
		return numberOfGhost;
	}
	public void setNumberOfGhost(int numberOfGhost) {
		this.numberOfGhost = numberOfGhost;
	}
	public int getNumberOfFoods() {
		return numberOfFoods;
	}
	public void setNumberOfFoods(int numberOfFoods) {
		this.numberOfFoods = numberOfFoods;
	}
	public void addItem(Item i) {
		items.add(i);
	}
	public boolean removeItem(Item i) {
		return items.remove(i);
	}
	
	
}
