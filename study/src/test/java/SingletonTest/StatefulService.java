package SingletonTest;

public class StatefulService {
	
	private int price;
	
	public void order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
		this.price = price; //여기가 문제!
	}
	
	public int getPrice() {
		return price;
	}
	
	//private int price2; 해결방법! 삭제후	
	public int order2(String name, int price2) {
		System.out.println("name = " + name + " price = " + price2);
		//this.price = price; //여기가 문제!
		
		return price2;
	}
	
	

}
