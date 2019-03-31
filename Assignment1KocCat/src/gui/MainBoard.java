package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameElements.Game;
import gameElements.Player;

public class MainBoard extends JFrame{

	Player currentPlayer;
	Game currentGame;
	public MainBoard(String title) {
		super(title);
		
		currentGame = new Game(3,4,currentPlayer);
		currentPlayer = new Player(210, 0, true, "/Users/euludag14/Desktop/comp132/Assignment1KocCat/image_right.png", "Emre", "Uludağ", 0);
		
		setLayout(null);		
		JButton playGame= new JButton("Play the game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int height = screenSize.height * 2 / 3;
		int width = screenSize.width * 1 / 3;
		setPreferredSize(new Dimension(width, height));

		int x = (screenSize.width-height)/4;
		int y = (screenSize.width-height)/4;
		setLocation(x,y);
		pack();


		playGame.setBounds(width/2-45,400,100, 40);  
		JLabel welcomeLabel= new JLabel("Welcome to Koc Cat Game");

		JLabel catimage = new JLabel();
		catimage.setIcon(new ImageIcon("/Users/euludag14/Desktop/comp132/Assignment1KocCat/logo.png"));
		catimage.setBounds(width/2-75,200,160,160);

		welcomeLabel.setBounds(width/2-150,100,300,40);
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

		add(welcomeLabel);
		add(catimage);
		add(playGame);

		setVisible(true);		
		try {
			ButtonHandler handler = new ButtonHandler();	
			playGame.addActionListener(handler);
		}catch(IllegalArgumentException e){
			System.out.println("You must enter positive number of foods and ghosts");
		}
	}

	private class ButtonHandler implements ActionListener 
	{

		public void actionPerformed(ActionEvent event)
		{	
//			getUserInfo(); 
			setVisible(false);
//			GameBoard name = new GameBoard(currentGame);
		}
	}


//	private void showGameBoard() {
//		GameBoard kocCatBoard= new GameBoard(currentGame,currentPlayer);
//
//	}
//	private void getUserInfo() {
//
//		try {
//			UserInfoPrompt user = new UserInfoPrompt();
//			user.askForInfo();
//			currentPlayer.setName(user.getFirstName());
//			currentPlayer.setSurName(user.getSurName());
//			currentPlayer.setScore(0);
//			currentGame.setNumberOfFoods(user.getFoodNumber());
//			currentGame.setNumberOfFoods(user.getGhostNumber());
//			System.out.println("I am here");
////			
//		}catch (Exception e) {
//			System.out.println("You did something wrong");
//		}
//
//
//	}


} 




