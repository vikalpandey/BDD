package collection_Naveen20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMap_To_ArryList {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> compMap=new HashMap<String, Integer>();
		compMap.put("Google", 1000);
		compMap.put("Walmart",2000);
		compMap.put("Amazon", 3000);
		compMap.put("Facebook",4000);
		compMap.put("Cisco",5000);
		
		System.out.println(compMap.size());
// we can not print hash map using for loop so we use iterator using entryset 
		Iterator it=compMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs=(Map.Entry)it.next();
			System.out.println(pairs.getKey()+" = " + pairs.getValue());
		}
		System.out.println("----------------");
// Print hash map using lamda expression 
		compMap.forEach((k,v) -> System.out.println("key = " + k + "value = "+v) );
		
// Converting hashmap keys into arraylist 
		List<String> compKeysList=new ArrayList<String>(compMap.keySet());
		System.out.println("Total comp count = " + compKeysList.size());
		for (String str : compKeysList) {
			System.out.println(str);
		}
		
// Cobnverting hashmap values into arraylist 		
		List<Integer> compValuesList=new ArrayList<Integer>(compMap.values());
		System.out.println("Total comp values count = " + compValuesList.size());
		for (Integer str : compValuesList) {
			System.out.println(str);
		}
		
		
	}
	
	
	
	

}
