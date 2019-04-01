package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameElements.Fruit;
import gameElements.Game;
import gameElements.Ghost;
import gameElements.Player;
import gameElements.Poison;

public class GameBoard extends JPanel implements KeyListener{

	public static final int baseX= 210;
	public static final int baseY= 0;
	public static final int step = 60;

	private String ghost1Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost1.png";
	private String ghost2Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost2.png";
	private String ghost3Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost3.png";

	private JFrame gameBoard = new JFrame("Koc Cat");
	private Game game;
	private Player player;

	Random rand = new Random();
	//	private Ghost testGhost;

	private Ghost ghosts[];
	private Poison poisons[];
	private Fruit fruits[];

	private Thread ghostThreads[];
	private Thread poisonThreads[];
	private Thread fruitThreads[];

	private int baseheight = 625;
	private int basewidth = 1000;
	private ImageIcon backgroundKocImage = new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/kocUni.png");

	public GameBoard(Game game) {

		this.game = game;
		this.player=game.getPlayer();
		player.setBoard(this);

		this.setFocusable(true);
		this.addKeyListener(this);
		this.setLayout(null);
		gameBoard.add(this);

		gameBoard.setSize(basewidth, baseheight);
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		gameBoard.setVisible(true);
		
		ghosts = new Ghost[game.getNumberOfGhost()];
		fruits = new Fruit[game.getNumberOfFruits()];
		poisons = new Poison[game.getNumberOfPoisons()];
		
		ghostThreads = new Thread[game.getNumberOfGhost()];
		fruitThreads = new Thread[game.getNumberOfFruits()];
		poisonThreads = new Thread[game.getNumberOfPoisons()];
		
		createGhosts(ghosts, ghostThreads);
		createFruits(fruits,fruitThreads);
		createPoisons(poisons,poisonThreads);
	}

	public void paint(Graphics g) {
		g.drawImage(backgroundKocImage.getImage(), 0, 0, null);
		player.drawItem(g);
		for (int i = 0; i < ghosts.length; i++) {
			ghosts[i].draw(g);	
		}
		for (int i = 0; i < fruits.length; i++) {
			fruits[i].draw(g);	
		}
		for (int i = 0; i < poisons.length; i++) {
			poisons[i].draw(g);	
		}
	}
	public Player getPlayer() {
		return player;
	}
	@Override
	public void keyTyped(KeyEvent event) {
	}
	@Override
	public void keyPressed(KeyEvent event) {
		player.move(event);
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}


	public void endGame() {
		JOptionPane.showMessageDialog(null, "Game over, Score: "+((player.getScore() < 0) ? 0 : player.getScore()));
		System.exit(0);
	}

	public void createGhosts(Ghost[] ghosts,Thread[] threads ) {

		for (int i = 0; i < ghosts.length; i++) {
			switch (i%3) {
			case 0:
				ghosts[i] = new Ghost (GameBoard.baseX+(rand.nextInt(8)+1)*step,GameBoard.baseY+(rand.nextInt(8)+1)*step,true,ghost1Path,this);
				break;
			case 1:
				ghosts[i] = new Ghost (GameBoard.baseX+(rand.nextInt(8)+1)*step,GameBoard.baseY+(rand.nextInt(8)+1)*step,true,ghost2Path,this);
				break;
			case 2:
				ghosts[i] = new Ghost (GameBoard.baseX+(rand.nextInt(8)+1)*step,GameBoard.baseY+(rand.nextInt(8)+1)*step,true,ghost3Path,this);
				break;
			}
			threads[i] = new Thread(ghosts[i]);
			threads[i].start();
		}
	}
	public void createFruits(Fruit[] fruits,Thread[] threads ) {

		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new Fruit(GameBoard.baseX+rand.nextInt(9)*step,GameBoard.baseY+rand.nextInt(9)*step,true,null,1, this);
			threads[i] = new Thread(fruits[i]);
			threads[i].start();
		}
	}
	public void createPoisons(Poison[] poisons,Thread[] threads ) {

		for (int i = 0; i < poisons.length; i++) {
			poisons[i] = new Poison(GameBoard.baseX+rand.nextInt(9)*step,GameBoard.baseY+rand.nextInt(9)*step,true,null,1, this);
			threads[i] = new Thread(poisons[i]);
			threads[i].start();
		}
	}

}




