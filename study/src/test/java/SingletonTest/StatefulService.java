package SingletonTest;

public class StatefulService {
	
	private int price;
	
	public void order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
		this.price = price; //���Ⱑ ����!
	}
	
	public int getPrice() {
		return price;
	}
	
	//private int price2; �ذ���! ������	
	public int order2(String name, int price2) {
		System.out.println("name = " + name + " price = " + price2);
		//this.price = price; //���Ⱑ ����!
		
		return price2;
	}
	
	

}
