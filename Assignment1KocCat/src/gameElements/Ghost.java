package gameElements;

import java.util.Random;

import javax.swing.JOptionPane;

import gui.GameBoard;

enum Direction{
	Up,Down,Left,Right;
}
enum GhostType {
	Capser,Dolly,Ash	
}


public class Ghost extends Item implements Runnable {
	private GhostType type;
	private boolean isMatched ;
	Direction currentDirectionAsh= Direction.Left;
	Direction currentDirectionDolly= Direction.Down;
	Random rand = new Random();
	public Ghost(int x, int y, boolean alive, String iconPath, GameBoard board) {
		super(x, y, alive, iconPath, board);
		if(iconPath.endsWith("ghost1.png")) type =GhostType.Ash;
		else if(iconPath.endsWith("ghost2.png")) type =GhostType.Dolly;
		else if(iconPath.endsWith("ghost3.png")) type =GhostType.Capser;
	}
	@Override
	public void run() {
		long time = 0;
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"The thread is interrupted!");
			}
			time += 100;
			if(time%300 == 0) {				
				doAction();
			}
			super.getBoard().repaint();
			isMatched = (super.getBoard().getPlayer().getX() == super.getX() ) && (super.getBoard().getPlayer().getY() == super.getY());
			if(isMatched) {
				super.getBoard().getPlayer().setAlive(false);
			}
			if(!super.getBoard().getPlayer().isAlive()) super.getBoard().endGame();
		}
	}

	public void holdInBorders() {
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
	}
	@Override
	public void doAction() {
		if(type==GhostType.Capser) {
			goRandom();
		}else if(type==GhostType.Ash) {
			goHorizontal();
		}else if(type==GhostType.Dolly) {
			goVertical();
		}
	}
	public void goRandom() {
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
		holdInBorders();
	}
	public void goHorizontal() {
		if(getX()<=210) {
			currentDirectionAsh=Direction.Right;
		}else if(getX()>710) {
			currentDirectionAsh=Direction.Left;
		}
		if(currentDirectionAsh.equals(Direction.Right))goRight();
		else if(currentDirectionAsh.equals(Direction.Left))goLeft();
		
	}
	public void goVertical() {
		if(getY()<=0) {
			currentDirectionDolly=Direction.Down;
		}else if(getY()>500) {
			currentDirectionDolly=Direction.Up;
		}
		if(currentDirectionDolly.equals(Direction.Up))goUp();
		else if(currentDirectionDolly.equals(Direction.Down))goDown();
	}

}




