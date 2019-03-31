package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameElements.Food;
import gameElements.Fruit;
import gameElements.Game;
import gameElements.Ghost;
import gameElements.GhostFactory;
import gameElements.Player;

public class GameBoard extends JPanel implements KeyListener{

	public static final int baseX= 210;
	public static final int baseY= 0;
	public static final int step = 60;

	private JFrame gameBoard = new JFrame("Koc Cat");
	private Game game;
	private Player player;
	
	private ArrayList<Ghost> ghosts;
	private ArrayList<Food> foods;
	
//	private String ghost1Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost1.png";
//	private String ghost2Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost2.png";
//	private String ghost3Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost3.png";

	private int baseheight = 625;
	private int basewidth = 1000;
	private ImageIcon backgroundKocImage = new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/kocUni.png");
	
	Fruit fruit = new Fruit(baseX,baseY+3*step,true,null,1,this);
	//	Fruit fruit =  new Fruit(265, 440, true, this);

	JLabel welcome = new JLabel("Welcome");
	//	JLabel name = new JLabel();

	public GameBoard(Game game,Player player) {

		this.game = game;
		this.player=game.getPlayer();
		player.setBoard(this);
		GhostFactory factory = new GhostFactory(game,player);
		
		for (int i = 0; i < game.getNumberOfGhost(); i++) {
			Ghost ghost = null;
			switch (i%3) {
			case 0:
				ghost = factory.getGhost("ghost1");
				break;
			case 1:
				ghost = factory.getGhost("ghost2");
				break;
			case 2:
				ghost = factory.getGhost("ghost3");
				break;
			}
			this.ghosts.add(ghost);
		}	
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setLayout(null);
		createLabels();
		gameBoard.add(this);

		
//		Thread thread = new Thread(ghost1);
//		thread.start();
//		Thread thread2= new Thread(ghost2);
//		thread2.start();
//		Thread thread3 = new Thread(ghost3);
//		thread3.start();
//		
//		Thread thread5 = new Thread(ghost5);
//		thread5.start();
//		Thread thread6= new Thread(ghost6);
//		thread6.start();
//		Thread thread7 = new Thread(ghost7);
//		thread7.start();
		
		gameBoard.setSize(basewidth, baseheight);
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		gameBoard.setVisible(true);
		
	}

	public void paint(Graphics g) {
		g.drawImage(backgroundKocImage.getImage(), 0, 0, null);
		player.drawItem(g);
//		ghost1.drawItem(g);
//		ghost2.drawItem(g);
//		ghost3.drawItem(g);
//		ghost5.drawItem(g);
//		ghost6.drawItem(g);
//		ghost7.drawItem(g);
		fruit.drawItem(g);
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
		gameBoard.add(welcome);
		welcome.setBounds(60, 40, 100, 100);
		//
		//		score_label = new JLabel("Your Score:");
		//		gameBoard.add(score_label);
		//		score_label.setBounds(60, 100, 100, 100);
		//
		//		score= new JLabel(Integer.toString(10));
		//		gameBoard.add(score);
		//		score.setBounds(60, 120, 100, 100);
		//
		//		fruit_label= new JLabel("Number Of fruits:");
		//		gameBoard.add(fruit_label);
		//		fruit_label.setBounds(820, 40, 200, 100);
		//
		//		number_fruit= new JLabel("10");
		//		gameBoard.add(number_fruit);
		//		number_fruit.setBounds(820, 60, 200, 100);
		//
		//		ghost_label = new JLabel("Number Of ghosts:");
		//		gameBoard.add(ghost_label);
		//		ghost_label.setBounds(820, 100, 200, 100);
		//
		//		number_ghost = new JLabel("10");
		//		gameBoard.add(number_ghost);
		//		number_ghost.setBounds(820, 120, 200, 100);

	}
	//	private void update() {
	//		Random rand = new Random();
	//		int a =rand.nextInt(10);
	//		welcome.setText("The is the string"+a);

	//	}
	public void warnPlayer() {
		JOptionPane.showMessageDialog(null, "You hit a ghost!");
	}
	
	public void congratsPlayer() {
		JOptionPane.showMessageDialog(null, "You get a fruit!");
	}
	
	public void drawItem(Graphics g) {

		ImageIcon image = new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png");
		g.drawImage(image.getImage(), 210, 0, null);
	}
	
	public GameBoard getItself() {
		return this;
	}


}
