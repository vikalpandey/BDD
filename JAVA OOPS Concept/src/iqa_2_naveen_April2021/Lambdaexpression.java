package iqa_2_naveen_April2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Lambdaexpression {
	
	public static void main(String[] args) {
		ArrayList<Integer> listobj=new ArrayList<Integer>();
		listobj.add(5);
		listobj.add(6);
		listobj.add(8);
		
		System.out.println("using lambda expression --------");
		
		listobj.forEach(   (n)   ->   {   System.out.println(n);  }    );
		
		//OR 
		System.out.println("using Java's Consumer interface to store a lambda expression in a variable: --------");
			
		Consumer<Integer> method= (n)-> {System.out.println(n);};
		listobj.forEach(method);
		
		
		
		System.out.println("using for each loop --------");
		for (Integer intgerobj : listobj) {
			System.out.println(intgerobj);
		}
		System.out.println("using for  loop --------");
		for (int i = 0; i < listobj.size(); i++) {
			System.out.println(listobj.get(i));
		}
		System.out.println("using iterator while   loop --------");
		 Iterator itr=listobj.iterator();
		 while (itr.hasNext()) {
			Object obj = (Object) itr.next();
			System.out.println(obj);
		}
		 
		 
		 
		
	}

}
