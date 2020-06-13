package p1;

public class AccessModifier {
	
	private int privateVariable=11;
	int defaultVariable=12;
	protected int protectedVariable=13;
	public int publicVariable=14;
	
	private void privateMethod()
	 {		 System.out.println("this is privateMethod");	 }
	
	 void defaultMethod()
	 {		 System.out.println("this is defaultMethod");	 }
	 
	 protected void protectedMethod()
	 {		 System.out.println("this is protectedMethod");	 }
	 
	 public void publicmethod()
	 {		 System.out.println("this is publicmethod");	
	//	private int privateVariable2=11; // inlegal modifier error 
		int defaultVariable2=12;           // only default variable is working remaining all are showing error 
		System.out.println(defaultVariable2);
	//	protected int protectedVariable2=13; // inlegal modifier error 
	//	public int publicVariable2=14;  // inlegal modifier error 
	 }
	 


}
