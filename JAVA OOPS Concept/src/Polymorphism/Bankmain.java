package Polymorphism;

public class Bankmain {

	
	public static void main(String[] args) {
		CityBank obj1=new CityBank();
		HDFCBank obj2=new HDFCBank();
		System.out.println("CityBank home loan obj1.getHomeLoanROI()=="+obj1.getHomeLoanROI());
		System.out.println("Hdfc bank home loan obj2.getHomeLoanROI()=="+obj2.getHomeLoanROI());
		System.out.println(obj2.getPersonalLoanROI());
		
	}
}
