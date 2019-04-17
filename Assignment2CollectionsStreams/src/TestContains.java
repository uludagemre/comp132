import java.util.ArrayList;
import java.util.List;

public class TestContains {
	
	public static void main(String[] args) {
		
		List<Actor> list = new ArrayList<Actor>();
		list.add(new Actor("Emre","Uludağ"));
		list.add(new Actor("Aylin","Uludağ"));
		
		System.out.println("List contains Emre Uludağ : "+ list.contains(new Actor("Emre","Uludağ")));
		
	}
}
