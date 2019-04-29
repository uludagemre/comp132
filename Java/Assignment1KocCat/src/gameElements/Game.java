package gameElements;

import java.util.ArrayList;

import gui.GameBoard;

public class Game {

	private int numberOfGhost;
	private int numberOfPoisons;
	private int numberOfFruits;
	private GameBoard board;
	private Player player;
	
	public Game (int ghost, int fruits,int poisons,Player player) {
		setNumberOfPoisons(poisons);
		setNumberOfFruits(fruits);
		setNumberOfGhost(ghost);
		setPlayer(player);
		
		
	}	
	public int getNumberOfPoisons() {
		return numberOfPoisons;
	}
	public void setNumberOfPoisons(int numberOfPoisons) {
		this.numberOfPoisons = numberOfPoisons;
	}
	public int getNumberOfFruits() {
		return numberOfFruits;
	}
	public void setNumberOfFruits(int numberOfFruits) {
		this.numberOfFruits = numberOfFruits;
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
	
	
	
	
}
