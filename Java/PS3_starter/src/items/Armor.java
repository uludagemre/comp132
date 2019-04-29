package items;

public class Armor extends Item implements Upgradable{

	private double defencePoints;
	private boolean isWorn;
	
	public Armor(double itemWeight,double defencePoints) {
		
		super(itemWeight);
		if (defencePoints < 0) defencePoints = 0;
		else this.defencePoints = defencePoints;
		this.isWorn = false;
	
	}
	
	
	public double getHit(double damagePoints){
		
		if(!isWorn()){
			return damagePoints;
		}
		if((damagePoints <= this.defencePoints) && isWorn()){
			this.defencePoints -= damagePoints;
			return damagePoints;
		}else if((damagePoints > this.defencePoints) && isWorn())
			this.defencePoints = 0;
			return damagePoints - this.defencePoints; 
		
	}
	
	public void upgrade(){
		this.defencePoints+=100;
	}
	
	
	

	public double getDefencePoints() {
		return this.defencePoints;
	}

	public boolean isWorn(){
		return this.isWorn;
	}



	@Override
	public boolean useItem() {
		this.isWorn = true;
		return true;
	}





	@Override
	public String toString() {
		return "Armor weight: " + super.getItemWeight() + " \n" + "Armor defense points: "+ getDefencePoints()+"\n";
	}
	
	
	
	
	
	
	
}
