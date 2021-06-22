package iqa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class FindDuplicatesElementsInArray {
	public static void main(String[] args) {
		
		//Approach 1- 
		int a[]={1,2,3,4,5,6,5,7,7,8,8,8};
		Map<Integer, Integer>  hm=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			int c=a[i];
			if (hm.get(c) != null ){
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}	
		
		}
		Iterator<Integer> tempString2=hm.keySet().iterator();
		while (tempString2.hasNext()) {
			Integer temp=tempString2.next();
			if (hm.get(temp)>1) {
				System.out.println("the Int value "+ temp +" appeared "+hm.get(temp)+" no of times");
			}
		}
		
		// 2).  Compare each element (Worst approcah beasue of if string is large then it takes lots of time )
		String name1[]={"java","rubey","c","java","perl","phython","c"};
		for (int i = 0; i < name1.length; i++) {
			for (int j = i+1; j < name1.length; j++) {
				if (name1[i].equals(name1[j])) {
					System.out.println("for loop duplicate element is =  "+ name1[i]);
				}
			}
		}
		//***************************************
		//Approach 3-> using hash set it stores unique values
		String names[]={"java","rubey","c","java","perl","phython","c"};
		Set<String> store=new HashSet<String>();   // in set object we can store only unique values
		for (String name : names) {
			if (store.add(name) == false) {
				System.out.println("Hashset duplicate element is =  " + name);
			}
		}
		//***************************************
		//Approach for int values  using hash set it stores unique values
		int a1[]={1,2,3,4,5,6,5,7,7,8,8,8};
		Set<Integer> set=new HashSet<Integer>();   // in set object we can store only unique values
		for (int name : a1) {
			if (set.add(name) == false) {
				System.out.println("Hashset int duplicate element is =  " + name);
			}
		}
		//***************************************
		//Approach 3 using hashmap 
		String name2[]={"java","rubey","c","java","perl","phython","c"};
		Map<String ,Integer> m=new HashMap<String ,Integer>();
		for (String namevar : name2) {
			Integer count =m.get(namevar);
			if (count == null) {
				m.put(namevar, 1);
			}
			else {
				m.put(namevar, ++count);
			}
		}
		// get the values from this hashmap object (entry set aways return set of entry)
		 Set<Entry<String, Integer>> entryset=m.entrySet();
	for (Entry<String, Integer> entry : entryset) {
		if (entry.getValue()>1) {
			System.out.println("Entry duplicate entry is = " +entry.getKey());
		}
	}
		
		
		

	}

}
