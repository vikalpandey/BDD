package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist_Generic {
	
	public static void main(String[] args) {
		//how to define userdifine classarray list 
		//create Arraylist_Generic_employee objects 
		Arraylist_Generic_employee e1= new Arraylist_Generic_employee("vikal",34,"qa");
		Arraylist_Generic_employee e2= new Arraylist_Generic_employee("Navneet",33,"dev");
		Arraylist_Generic_employee e3= new Arraylist_Generic_employee("anupam",39,"lead");
		
		ArrayList<Arraylist_Generic_employee> ar=new ArrayList<Arraylist_Generic_employee>();
		ar.add(e1);
		ar.add(e2);
		ar.add(e3);
		//iterate to traverse the value
		Iterator<Arraylist_Generic_employee> itr=ar.iterator();
		while (itr.hasNext()) {
			Arraylist_Generic_employee emp =  itr.next();
			System.out.println(emp.name);
			System.out.println(emp.age);
			System.out.println(emp.dept);
		}
	
		//addall -: adding 1st list into 2nd list 
		
		ArrayList<String> ar2=new ArrayList<String>();
		ar2.add("apple");
		ar2.add("banana");
		ar2.add("mango");
		
		ArrayList<String> ar3=new ArrayList<String>();
		ar3.add("java");
		ar3.add("c");
		ar3.add("mango");
		
		ar2.addAll(ar3);
		for (int i = 0; i < ar2.size(); i++) {
			System.out.println(ar2.get(i));
		}
		
		ar2.removeAll(ar3);
		for (int i = 0; i < ar2.size(); i++) {
			System.out.println(ar2.get(i));  //O/P= apple, banana (mango is common so that removed)
		}
		//now if you want to check the common part (intersection part)
		System.out.println("retain method for common data in list it will work if addall and remove all method not used ");
		ar2.retainAll(ar3);
		for (int i = 0; i < ar2.size(); i++) {
			System.out.println(ar2.get(i));  //O/P=mango if we comment add all and remove all (means new 2 array list )
		}
	
		
		
		
		
	}

}
