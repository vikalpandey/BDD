package collection;

import java.util.ArrayList;
import java.util.Iterator;
public class Arraylist {
	public static void main(String[] args) {
		
		ArrayList list=new ArrayList();   //import java.util.ArrayList;
		list.add(10);
		list.add(10.5);
		list.add('a');
		list.add("vikal");
		list.add(null);
		list.add("vikal");
		
		System.out.println(list); // print the list
		System.out.println(list.size());
		
		// fetch the value from list
		System.out.println(list.get(0));
		// remove value from list
		list.remove(1);
		
//*****Retrive value from a list 1-for loop, 2 for-each loop, 3- iterator interface		
        System.out.println("For loop -------");
	// printing each item of array 1 by 1 	
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("For each loop  Variabletype var :list -------");
	for (Object object : list) {
		System.out.println(object);
	}

	System.out.println("iterator interface -------");
	
		Iterator itr=list.iterator();
		//Iterator do not know how much size so we use while loop
		while(itr.hasNext()) // this lopp will be run till the time iteration will be true
		{
			System.out.println(itr.next());
		}
	
//*****Drawback 
		System.out.println("Drwaback store  value in a valriable---------------");
		System.out.println(list.get(0));//		i want to store this value in a valriable 
	//int i=list.get(0);// we can not store this value directly to int because it returning a object and this will be store only and only in object	
		Object var=list.get(0);
		System.out.println(var);
		//System.out.println(20+var); it is not possible it gives error we can not add value in object
		// another way is to typecast // we need to know what is the value type (int float char ) index is returing
		
		int var1=(Integer)list.get(0);
		System.out.println(20+var1);// 
		System.out.println(var1);
		System.out.println(list);
		//this is not the exact way of using it 
		//so here we can use the concept of ***genrix*** so we create a class -GenericArrayList
		
		
		
	}

}
