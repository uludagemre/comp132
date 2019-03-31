package gameElements;

import java.util.Random;

import javax.swing.JOptionPane;

import gui.GameBoard;

public class Ghost extends Item implements Runnable {
	private boolean isMatched ;
	Random rand = new Random();
	public Ghost(int x, int y, boolean alive, String iconPath, GameBoard board) {
		super(x, y, alive, iconPath, board);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"The thread is interrupted!");
			}
			int choose = rand.nextInt(4);
			
			switch (choose) {
			case 0:
				goDown();
				break;
			case 1:
				goLeft();
				break;
			case 2:
				goRight();
				break;
			case 3:
				goUp();
				break;
			}
			if(getY()>=550) {
				goUp();
			}
			if(getY()<=0) {
				goDown();
			}
			if(getX()>=800) {
				goLeft();
			}
			if(getX()<=155) {
				goRight();
			}
			super.getBoard().repaint();
			isMatched = (super.getBoard().getPlayer().getX() == super.getX() ) && (super.getBoard().getPlayer().getY() == super.getY());
			if(isMatched) {
				super.getBoard().warnPlayer();
			}
		}
	}
}



