package p1;

public class Comp_SingleTonTest {
	
 private static Comp_SingleTonTest instance=new Comp_SingleTonTest();
	
//should have constructor as private so that no one can create 
//the object of the class
 private Comp_SingleTonTest()
	{
		System.out.println("Creating Objects");
	}

 public static Comp_SingleTonTest getInstance() 
 //return type =classname ,create an object of this class using 
 //public method and return type 
	{
		return instance;
	}
}
