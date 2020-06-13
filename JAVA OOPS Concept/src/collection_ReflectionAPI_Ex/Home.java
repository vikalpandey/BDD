package collection_ReflectionAPI_Ex;

import java.lang.reflect.Method;

public class Home {
	public static void main(String[] args) {
		Test t=new Test();
		Class cla=t.getClass();//Class is also a class in java and with the help of this cla variable we get get any information of this class
		
		System.out.println(cla.getSimpleName());
		Method[] arryofmethods  =cla.getDeclaredMethods(); //Method is also a class in java 
		System.out.println(arryofmethods.length);// o/p=4
		for (Method m : arryofmethods) {
			System.out.println(m.getName()); //O/p=main, Add,method1,Sub
			// with the help of reflection we can also know about private methods as well method 1 is private method
			// we can fetch many information like class name , methods name with return type, and parmeter, constrructor name 
			
	
		}
	}
	
	
	

}
