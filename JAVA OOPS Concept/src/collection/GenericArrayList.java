package collection;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayList {

	public static void main(String[] args) {
		
		//ArrayList list=new ArrayList();// this is ok import java.util.ArrayList;
		//List list0=new ArrayList();// this is also ok  lso define data type but not permitive data types 
       // collection does not work on premitive data type (int,char..) it works on classes and object only 
		//so we need to define class name only
		
		List<Integer> list=new ArrayList<Integer>();// this arrylist will store integer values
		list.add(10);
		System.out.println(list);
		//list.add(10.5);  // compiler gives an error due to we define this list only for interger values
		//so actually in java we can create an array list in this format only to avoid the type casting issue 
		//so in future we may not face any type casting issue 
		list.add(null);
		list.add(null);
		System.out.println(list);// O/P=[10, null, null]
		System.out.println(list.get(0));
		//or
		int i=list.get(0); // now here you are not typecasting but in arraylist class we need to type cast
		System.out.println(i);
		
		
		
		


		
		

	}

}
