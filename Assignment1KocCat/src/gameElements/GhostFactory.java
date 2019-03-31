package gameElements;

import gui.GameBoard;

public class GhostFactory extends GameBoard {
	  //use getShape method to get object of type shape 
	private final String ghost1Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost1.png";
	private final String ghost2Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost2.png";
	private final String ghost3Path =  "/Users/euludag14/Desktop/comp132/Assignment1KocCat/ghost3.png";	
	public GhostFactory(Game game, Player player) {
		super(game, player);
	}
	
	public Ghost getGhost(String ghostType){
	      if(ghostType== null){
	         return null;
	      }		
	      if(ghostType.equalsIgnoreCase("ghost1")){
	      return new Ghost(GameBoard.baseX+1*step,GameBoard.baseY+1*step,true,ghost1Path,super.getItself());
	         
	      } else if(ghostType.equalsIgnoreCase("ghost2")){
	    	  return new Ghost(GameBoard.baseX+3*step,GameBoard.baseY+3*step,true,ghost2Path,super.getItself());
	         
	      } else if(ghostType.equalsIgnoreCase("ghost3")){
	    	  return new Ghost(GameBoard.baseX+5*step,GameBoard.baseY+5*step,true,ghost3Path,super.getItself());
	      }
	      
	      return null;
	   }
}
