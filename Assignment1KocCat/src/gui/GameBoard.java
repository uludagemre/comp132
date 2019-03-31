package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameElements.Food;
import gameElements.Fruit;
import gameElements.Game;
import gameElements.Ghost;
import gameElements.Player;

public class GameBoard extends JPanel implements KeyListener{

	public static final int baseX= 210;
	public static final int baseY= 0;
	public static final int step = 60;

	private JFrame gameBoard = new JFrame("Koc Cat");
	private Game game;
	private Player player;

	private String ghost1Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost1.png";
	private String ghost2Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost2.png";
	private String ghost3Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost3.png";
	private Ghost testGhost;
	private int baseheight = 625;
	private int basewidth = 1000;
	private ImageIcon backgroundKocImage = new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/kocUni.png");

	//	Fruit fruit = new Fruit(baseX,baseY+3*step,true,null,1,this);
	//	Fruit fruit =  new Fruit(265, 440, true, this);
	public GameBoard(Game game) {

		this.game = game;
		this.player=game.getPlayer();
		player.setBoard(this);
		testGhost= new Ghost (GameBoard.baseX+1*step,GameBoard.baseY+1*step,true,ghost1Path,this,1);
		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setLayout(null);
		createLabels();
		gameBoard.add(this);


		Thread thread = new Thread(testGhost);
		thread.start();
	

		gameBoard.setSize(basewidth, baseheight);
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		gameBoard.setVisible(true);

	}

	public void paint(Graphics g) {
		g.drawImage(backgroundKocImage.getImage(), 0, 0, null);
		player.drawItem(g);
		testGhost.drawItem(g);
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
		// TODO Auto-generated method stub

	}
	private void createLabels() {

	}
	

	//	}
	public void warnPlayer() {
		JOptionPane.showMessageDialog(null, "You hit a ghost!");
	}

	public void congratsPlayer() {
		JOptionPane.showMessageDialog(null, "You get a fruit!");
	}

//	public void drawItem(Graphics g) {
//
//		ImageIcon image = new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png");
//		g.drawImage(image.getImage(), 210, 0, null);
//	}

	public GameBoard getItself() {
		return this;
	}


}
