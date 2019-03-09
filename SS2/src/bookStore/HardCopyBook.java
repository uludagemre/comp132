package bookStore;

public class HardCopyBook extends Book{

	private double weight;
	private double shippingCost;
	
	public HardCopyBook(String name, double price, String bookId , double weight, double shippingCost) {
	
		super(name, price, bookId);
		this.shippingCost = shippingCost;
		this.weight = weight;

	}
	
	
}
