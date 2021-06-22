package collection_Naveen20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class HashMap_basic {

	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=MQtigRHn7WU
		
		HashMap<String, String> capitalmap=new HashMap<String, String>();
		capitalmap.put("India", "Delhi");
		capitalmap.put("USA", "NY");
		capitalmap.put("UK", "London");
		capitalmap.put("UK", "London updated");
		capitalmap.put(null, "barlin");
		capitalmap.put(null, "LA");    // only 1 null key (means always gives upadted value)
		capitalmap.put("china", null);
		capitalmap.put("japan", null); //store n no of null values but only 1 null key 
		capitalmap.put("pak", "islamabad");
	//  Remove mthod
			capitalmap.remove("pak");
		
		
		System.out.println(capitalmap.get("USA"));    // o/p= NY
		System.out.println(capitalmap.get("nepal"));  // o/p= null
		System.out.println(capitalmap.get("UK"));    // o/p= London updated
		System.out.println(capitalmap.get(null));    // o/p= LA  
		System.out.println(capitalmap.get("Japan")); // o/p= null
		System.out.println("-------------------------------------------");
		
		//How to traverse becasue it does not maintain the order so we can not use for loop
		
		//1. Iterator  -> two type of iterator 1, fo keys and 2 for values
		//before that we have use keyset  so - give me all the key values
		
		//iterator: Over the keys: by using key set
		Iterator<String> it =capitalmap.keySet().iterator();
	while (it.hasNext()) {
		//System.out.println(it.next());  // print all values only
		String key=it.next();
		String value=capitalmap.get(key);
		System.out.println("key = "+key +"    value ="+value);
	}
//		o/p=
//	        key = null    value =LA
//			key = USA    value =NY
//			key = china    value =null
//			key = japan    value =null
//			key = UK    value =London updated
//			key = India    value =Delhi
	
	System.out.println("----------------------------------");
	//iterator: Over Set (pair) : by using entryset
		Iterator<Entry<String, String>> it1=capitalmap.entrySet().iterator();
		while (it1.hasNext()) {
			Entry<String,String> entry=it1.next();
			System.out.println("key = "+ entry.getKey()+"   value= "+ entry.getValue() );	
		}
//		o/p=
//				key = null   value= LA
//				key = USA   value= NY
//				key = china   value= null
//				key = japan   value= null
//				key = UK   value= London updated
//				key = India   value= Delhi

		
		System.out.println("----------------------------------");
		//iterate hashmap using java 8 for each and lambda
		capitalmap.forEach((k,v)-> System.out.println("key= "+k  +  " value= " +v ));
//		o/p= 
//				key= null value= LA
//				key= USA value= NY
//				key= china value= null
//				key= japan value= null
//				key= UK value= London updated
//				key= India value= Delhi

		
		
	}
	
	
	
	
	
}
