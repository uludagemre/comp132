package items;

import exceptions.OutOfArrowException;

public class Bow extends Weapon implements Upgradable {

	private int numOfArrows;

	public Bow(double itemWeight, double damage, int numOfArrows) {
		super(itemWeight, damage);
		if (numOfArrows < 0) this.numOfArrows = 0;
		else this.numOfArrows=numOfArrows;
		
		
		// TODO Auto-generated constructor stub
	}
	public void useArrow() throws OutOfArrowException{
		if (numOfArrows > 0){
			this.numOfArrows--;
		}else{
			throw new OutOfArrowException();
		}
	}
	
	
	
	public int getNumOfArrows() {
		return numOfArrows;
	}
	@Override
	public boolean useItem() {
		try {
			useArrow();
			System.out.println("The Bow is used to throw an arrow and caused damage"+
" of "+ super.getDamageAmount()+" points.");
			return true;
		} catch (OutOfArrowException e) {
			System.out.print(e);
			System.out.println(" There is no arrow left.");
			return false;
		}
		
	}
	public void upgrade(){
		this.numOfArrows += 10;
	}
	@Override
	public String toString() {
		return"Weapon type: Bow \n"+ 
				"Number of arrows: "+getNumOfArrows()+"\n"+
				super.toString();
	}
	
	
	
	
}
