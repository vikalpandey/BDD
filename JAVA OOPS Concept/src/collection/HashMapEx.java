package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		
		Map<String,String>  map=new HashMap <String,String>();
		//here both string can change to  STRING , INTEGER ETC
		
		map.put("firstname","vikal");
		map.put("lasttname","pandey");
		map.put("dob", "1july1990");
		map.put("firstname","vikal1"); //it will override the previous keyand value -duplicasy not allowed
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("firstname"));
		
		// how to get all keys and values
		Set<String> keys =map.keySet();
		for (String key : keys) {
			System.out.println("key is ="+key +", Value is ="+map.get(key));
		}
		
		// a key can have value in a form of list as well ex-: in excel we have email list in one column 
		// heading is Email and values are many multiple values 
		//Email (Column name )
		//vikal@gmail.com
		//Navneet@gmail.com  etc 
		
		Map<String,List<String>>  map1=new HashMap <String,List<String>>();
		// first we create a list of emails
		
		List<String> listofemail=new ArrayList<String>();
		listofemail.add("vikal@gmail.com");
		listofemail.add("navneet@gmail.com");
		listofemail.add("anupam@gmail.com");
		
		map1.put("Email",listofemail);
		System.out.println(map1); //O/p={Email=[vikal@gmail.com, navneet@gmail.com, anupam@gmail.com]}
		
		//you can also create 
		Map<String, Map<String, String>> map2=new HashMap<String,Map<String, String>>();
		

	}

}
