//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Emre Uludağ
package runner;

import javax.swing.JOptionPane;

import gameElements.Game;
import gameElements.Player;
import gui.GameBoard;
import gui.MainBoard;

public class App {

	public static void main(String[] args) {

		boolean mustExit = false;
		MainBoard main= new MainBoard("Koç Cat Game");   
		String first_name = JOptionPane.showInputDialog("Enter First Name");
		String second_name = JOptionPane.showInputDialog("Enter Second Name");

		int number_ghost;
		int number_fruits;
		int number_poisons;
		try{
			number_ghost =Integer.parseInt(JOptionPane.showInputDialog("Enter number of Ghosts"));
			if(number_ghost <= 0) throw new IllegalArgumentException();
		}catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null,"You entered an unaccepted argument");
			mustExit =true;
			return;
		}finally {
			if(mustExit)System.exit(0);
		}
		try{
			number_fruits =Integer.parseInt(JOptionPane.showInputDialog("Enter number of Fruits"));
			if(number_fruits <= 0) throw new IllegalArgumentException();
		}catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null,"You entered an unaccepted argument");
			mustExit =true;
			return;
		}finally {
			if(mustExit)System.exit(0);
		}
		try{
			number_poisons =Integer.parseInt(JOptionPane.showInputDialog("Enter number of Poisons"));
			if(number_poisons <= 0) throw new IllegalArgumentException();
		}catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null,"You entered an unaccepted argument");
			mustExit =true;
			return;
		}finally {
			if(mustExit)System.exit(0);
		}
		
		Player player = new Player(GameBoard.baseX,GameBoard.baseY,true,"image_right.png",first_name,second_name,0);
		Game game = new Game(number_ghost,number_fruits,number_poisons,player);
		showGameBoard(game,first_name,second_name);	
	}
	private static void showGameBoard(Game game,String first_name,String second_name) {
		JOptionPane.showMessageDialog(null,"Welcome to the game "+first_name+" "+second_name+". Your inital score is 0.");
		GameBoard main= new GameBoard(game); 
	}
}
