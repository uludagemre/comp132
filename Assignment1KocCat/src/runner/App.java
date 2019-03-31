package runner;

import gameElements.Game;
import gameElements.Player;
import gui.GameBoard;
import gui.MainBoard;

public class App {

	public static void main(String[] args) {
		Player player = new Player(210,0,true,"/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png","Emre","Uludağ",0);
		Game game = new Game(3,2,player);
		showGameBoard(game, player);	
	}
	private static void showMain() {
		MainBoard main= new MainBoard("Koç Cat Game");   
	}
	private static void showGameBoard(Game game,Player player) {
		GameBoard main= new GameBoard(game,player); 
	}
}
