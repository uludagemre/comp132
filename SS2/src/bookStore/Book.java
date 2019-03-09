package bookStore;

public class Book {
	
	private String name;
	private double price;
	private String bookId;
	
	
	public Book(String name, double price, String bookId) {
		this.name = name;
		this.price = price;
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public void applyDiscount(double discountPercentage) {
		setPrice(getPrice()-getPrice()*discountPercentage/100);
	}
	public double getTotalCost(){
		return getPrice();
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", bookId=" + bookId + "]";
	}
	
	
}
