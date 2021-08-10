package string;

public class Overiding extends Overloading {
	
	public void Display()
	{
		System.out.println("display method 2 ");
	}
	
	public static void main(String[] args) {
		Overiding obj2=new Overiding();
		obj2.Display();
		
		Overloading obj3=new Overiding();
		obj3.Display();
		
		obj3.login(123, 1233);
		
	}

}
