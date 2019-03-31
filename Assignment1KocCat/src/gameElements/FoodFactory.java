package gameElements;

import java.util.Random;

import gui.GameBoard;

public class FoodFactory extends GameBoard{
	//use getShape method to get object of type shape 
		
	public FoodFactory(Game game, Player player) {
		super(game, player);
	}
	Random rand = new Random();
	public Food getFood(String foodType){
		
		if(foodType== null){
			return null;
		}		
		if(foodType.equalsIgnoreCase("fruit")){
			return new Fruit(GameBoard.baseX+rand.nextInt(10)*step,GameBoard.baseY+rand.nextInt(10)*step,true,null,0,super.getItself());

		} else if(foodType.equalsIgnoreCase("poison")){
			return new Poison(GameBoard.baseX+rand.nextInt(10)*step,GameBoard.baseY+rand.nextInt(10)*step,true,null,0,super.getItself());
		}
		return null;
	}
}

