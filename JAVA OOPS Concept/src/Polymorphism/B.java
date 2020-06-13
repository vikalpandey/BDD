package Polymorphism;
public class B extends A{
	public static void main(String[] args) {
//		B obj=new B();
//		obj.staticMethod(); //O/p= Child B staticMethod
//		staticMethod();//O/p= Child B staticMethod
//		A.staticMethod();//O/p= Parent A staticMethod
//		B.staticMethod();//O/p= Child B staticMethod
//		
//		A obj2=new B(); //Polymorphic reference 
//		obj2.staticMethod();//O/p= Parent A staticMethod
//		staticMethod(); //O/p= Child B staticMethod
		
	
		
		
	}
	public static void staticMethod()
	{
		System.out.println("Child B staticMethod");
	}
	public void add()
	{
		System.out.println("parent add");
	}
	public void onlyChild_Add()
	{
		System.out.println("parent add");
	}

}
