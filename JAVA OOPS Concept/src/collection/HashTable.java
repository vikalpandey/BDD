package collection;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		
		Hashtable h  =new Hashtable();
		h.put("firstname", "Vikal");
		h.put("lastname", "Pandey");
		h.put("DOB", "10/06/1989");
		h.put("mobile", "9953010000");
		System.out.println(h); //O/p= {mobile=9953010000, DOB=10/06/1989, lastname=Pandey, firstname=Vikal}
		System.out.println(h.size());
		System.out.println(h.get("lastname")); //O/P= Pandey
		h.put("2", "india");
		System.out.println(h.size());
		System.out.println(h.get("2")); //O/P= india
		h.put("2", "india 2 updated");
		System.out.println(h.get("2")); //O/P= india 2 updated
		
		Hashtable<Integer, Integer> h1=new Hashtable<Integer, Integer>();
		h1.put(1,100);
		//h1.put("2", "200"); // showing error becasue of h1 is accepting only int value 
		h1.put(2, 200);
		System.out.println(h1.size());
		System.out.println(h1.get(1));
		h1.put(2, 250);
		System.out.println(h1.get(2));
		
		
		
		
		
		
	}
	
	
}
