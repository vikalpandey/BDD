package Util;

public class Singleton {

//	In oops single ton class is a class that can have only once object (instance of the class) at a time 
//		How to design singleton class
//	1.Make constructor as private 
//	2. Write a static method  that has return type of object of this singleton class (Lazy Initialization)

	
	private static Singleton singleton_instance= null;
	public String stringvar;
	
	private Singleton(){  //	1.	Make constructor as private 
		stringvar="Good Morning";
	}
	public static Singleton getInstance(){ //2.static method has return type of object of this singleton class
		if(singleton_instance == null){
			 singleton_instance = new Singleton();
			 }
		return singleton_instance;
		
	}
// if we create many object of this class then it point to to single object only 	
	public static void main(String[] args) {
		Singleton x=Singleton.getInstance(); //1st time a object is created
		Singleton y=Singleton.getInstance();// 2nd time it will check that obj (singleton_instance)==null or not 
		Singleton z=Singleton.getInstance();//if null then nor create another object 
		
		//x.stringvar=x.stringvar.toUpperCase();
		System.out.println(x.stringvar);
		System.out.println(y.stringvar);
		System.out.println(z.stringvar);
		
	}
	

	
	
	
}
