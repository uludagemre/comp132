package items;

public abstract class Item {

	private double ItemWeight;

	public Item(double itemWeight) {
		if(itemWeight < 0) this.ItemWeight = 0;
		else this.ItemWeight = itemWeight;
	}
	
	
	public double getItemWeight() {
		return this.ItemWeight;
	}


	public abstract boolean useItem();
			
}
