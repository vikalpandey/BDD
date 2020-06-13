package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {
	
	public static void main(String[] args) {
		
		
		//HashSet<String> set=new HashSet<String>();  
		//or
		Set<String> set=new HashSet<String>();
		set.add("vikal");
		set.add("navneet");
		set.add("anupam");
		set.add("ceo");
		set.add("vikal");
		System.out.println(set);//o/p=[vikal, navneet, ceo, anupam];;; added order is not same as added
		//System.out.println(set.get());//no get method in set because of unordered
		
		//get out all values of set using foreach loop
		for (String var : set) {
			System.out.println(var);
		}
		//get out all values of set using iterator and matching value
		
		Iterator<String> itr=set.iterator();
		while (itr.hasNext()) {
			
			String var=itr.next();
			if (var.equalsIgnoreCase("vikal")) {
				System.out.println(var);
			}
		}
		
		
		
	}
	

}
