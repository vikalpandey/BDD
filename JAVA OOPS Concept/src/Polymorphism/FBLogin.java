package Polymorphism;
public class FBLogin {
	public static void main(String[] args) {
		FBLogin obj=new FBLogin();
	obj.getHomeLoanROI("HDFC bank" );
	}
	
	public static void main(int a) {
		FBLogin obj2=new FBLogin();
	obj2.getHomeLoanROI("ICICI bank" );
	}


	
	
	
		
	
	
	
	
	public void getHomeLoanROI(String Bankname)
	{
		System.out.println(Bankname);
	}
	
	public void getHomeLoanROI(String Bankname, int amount)
	{
		
	}
}
