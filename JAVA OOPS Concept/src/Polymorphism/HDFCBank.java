package Polymorphism;

public class HDFCBank extends RBI {
 public static void main(String[] args)
 {	
    HDFCBank obj=new HDFCBank();
     System.out.println(obj.getObject());
 }

	public HDFCBank getObject()
	{
		HDFCBank obj=new HDFCBank();
		return obj;
	}
	
	
	
	
	
	
	
	
	public double getHomeLoanROI()
	{
		return 12;
	}
	
	public double getCarLoanROI()
	{
		return 12.1;
	}
	public static double getPersonalLoanROI()
	{
		return 12.2;
	}
	
	

}
