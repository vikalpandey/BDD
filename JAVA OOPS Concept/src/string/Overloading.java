package string;

public class Overloading {
	
	public static void main(String[] args) {
		Overloading obj=new Overloading();
		obj.login(100, 100);
		obj.login("vikal", 123);
		
		
	}
public void Display()
{
	System.out.println("display method ");
}
	
	
	public void login(int empid, int pw)
	{
		System.out.println("login1 succesfully");
	}
	public void login(String  username, int pw)
	{
		System.out.println("login2 succesfully");
	}
	
	
	
	
}
