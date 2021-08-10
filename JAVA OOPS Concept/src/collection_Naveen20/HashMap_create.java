package collection_Naveen20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMap_create {
	
	public static Map<String, Integer> marksMap;
	static {
		marksMap= new HashMap<>();
		marksMap.put("A", 100);
		marksMap.put("B", 200);
		
	}
	
public static void main(String[] args) {
//1.  using HashMap class
	HashMap<String, String> map1=new HashMap<>();
	Map<String, String> map2= new HashMap<>();
	
// 2. static way : static hashmap
	// create static block immidiate after the class
	System.out.println(HashMap_create.marksMap.get("A"));  // o/p = 100
	
// 3. immutablemap with only 1 single entry
	Map<String, Integer> map3=Collections.singletonMap("test", 100);
	System.out.println(map3.get("test"));  // o/p = 100
	map3.put("ABC", 200); //O/ p = Exception in thread "main" java.lang.UnsupportedOperationException
	
// 4. JDK 8 introduce 2 methods
	Map<String, String> map4= Stream.of(new String [][] {
		{"TOM", "A Grade"},
		{"Naveen","A+ Grade"},
	}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
	System.out.println(map4.get("TOM"));
	map4.put("Lisa","A++ Grade");
	System.out.println(map4.get("Lisa"));
	
	
	
	
}
}
