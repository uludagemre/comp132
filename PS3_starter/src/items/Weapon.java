package items;

public abstract class Weapon extends Item {
	private double damageAmount;

	public Weapon(double itemWeight, double damage) {
		super(itemWeight);
		if (damage < 0) this.damageAmount = 0; 
		else this.damageAmount = damage;
	}
	


	public double getDamageAmount() {
		return damageAmount;
	}


	@Override
	public String toString() {
		return "Weapon weight: " +super.getItemWeight()+ "\n"+
	"Weapon damage amount: "+ getDamageAmount()+"\n";
	}
	
	
	
	
}
