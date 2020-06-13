package Polymorphism;

public class CityBank extends RBI {
	public static void main(String[] args) {
		
		CityBank obj=new CityBank();
		System.out.println(obj.getHomeLoanROI());
		System.out.println(obj.getCarLoanROI());
	}
	
	public double getHomeLoanROI()
	{
		return 11;
	}
	
	public double getCarLoanROI()
	{
		return 11.1;
	}

}
