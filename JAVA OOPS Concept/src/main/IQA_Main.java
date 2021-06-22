package main;

public class IQA_Main {
	
	public void IQA_Main(){
		System.out.println("this is constructor");
	}
	
	 public static  void main(String[] args) {
		System.out.println("this is main method");
		IQA_Main ob=new IQA_Main();
		

	}
	 
	 
//	 static public void main(String[] args) {  => OK
//
//			 ****[Remove -public]=> if private, default or protected > then it will not work
//			 static  void main(String[] args) {             =>  Not Run (Error: Main method not found in class) it must be public
//
//			 **** Void-> int
//			 public static int main(String[] args) {
//			 		System.out.println("this is main method");
//			 		int i=10; 
//			 		return 1; O/P => Error: Main method must return a value of type void
//			 **** change the main  name 
//			 public static void main1(String[] args) { O/P=> Error: Main method not found in class
//
//			 **** remove static 
//			 public  void main(String[] args) { O/P=> Error: Main method is not static in class


}
