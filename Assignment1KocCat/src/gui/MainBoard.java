package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
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
		setLayout(null);		
		JButton playGame= new JButton("Ali");

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
		JLabel clickLabel= new JLabel("Click to Start");
		JLabel catimage = new JLabel();
		catimage.setIcon(new ImageIcon("logo.png"));
		catimage.setBounds(width/2-75,200,160,160);

		welcomeLabel.setBounds(width/2-150,100,300,40);
		clickLabel.setBounds(width/2-145,400,300,40);
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		clickLabel.setHorizontalAlignment(JLabel.CENTER);

		add(welcomeLabel);
		add(clickLabel);
		add(catimage);
		add(playGame);

		setVisible(true);
		playGame.setAction(new AbstractAction() {
			public void actionPerformed(ActionEvent ae) {
				synchronized (playGame) {
					playGame.notify();
					setVisible(false);
				}
			}
		});
		synchronized(playGame) {
			try {
				playGame.wait();
			} catch (InterruptedException ex) {
				System.out.println("Interrupted");
			}
		}
	}
}




