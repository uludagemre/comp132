package items;

public class Sword extends Weapon{

	public Sword(double itemWeight, double damage) {
		super(itemWeight, damage);
	}

	@Override
	public boolean useItem() {
		System.out.println("The Sword is used and caused damage of "+super.getDamageAmount() +" points.");
		return true;
	}

	@Override
	public String toString() {
		return "Weapon type: Sword \n" + super.toString();
				
	}
	
	

	
	
}
