package collection_Naveen20;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashMap_Compare {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		
		HashMap<Integer, String> map2=new HashMap<Integer, String>();
		map2.put(3, "C");
		map2.put(1, "A");
		map2.put(2, "B");
		
		HashMap<Integer, String> map3=new HashMap<Integer, String>();
		map3.put(1, "A");
		map3.put(2, "B");
		map3.put(3, "C");
		map3.put(3, "D");
//Comparision
		// 1-:  on the basis of key-value format  -: equal method
		System.out.println(map1.equals(map2));  //o/p= true 
		System.out.println(map1.equals(map3));  //o/p= false
		
		//2-:  compare hashmap for the same keys: keyset():
		// keyset by default give you a set (remove duplicate values)
		System.out.println(map1.keySet().equals(map2.keySet()));   //o/p= true 
		System.out.println(map1.keySet().equals(map3.keySet()));   //o/p= true 
// 3-: Find out the extra keys : (Imp Interview Question)
		
		HashMap<Integer, String> map4= new HashMap<Integer, String>();
		map4.put(1, "A");
		map4.put(2, "B");
		map4.put(3, "C");
		map4.put(4, "D");
		// combine the keys from both the hash maps: using HashSet(store only unique values and does not in key value)
		HashSet<Integer> combinekeys=new HashSet<>(map1.keySet());
		//add keyset from map4 also
		combinekeys.addAll(map4.keySet());
		combinekeys.removeAll(map1.keySet()); // remove all the keys coming from map1
		System.out.println(combinekeys); //o/p = [4]
		
		
		
// 4-: compare map by values:
		HashMap<Integer, String> map5=new HashMap<Integer, String>();
		map5.put(1, "A");
		map5.put(2, "B");
		map5.put(3, "C");
		
		HashMap<Integer, String> map6=new HashMap<Integer, String>();
		map6.put(4, "A");
		map6.put(5, "B");
		map6.put(6, "C");
		
		HashMap<Integer, String> map7=new HashMap<Integer, String>();
		map7.put(1, "A");
		map7.put(2, "B");
		map7.put(3, "C");
		map7.put(4, "C");
		System.out.println("---------------------");
		//condition 1 - duplicated are not allowed using arraylist
		System.out.println(new ArrayList<>(map5.values()).equals(new ArrayList<>(map6.values()))); //o/p= true
		System.out.println(new ArrayList<>(map5.values()).equals(new ArrayList<>(map7.values()))); //o/p= false
		
		//condition 1 - duplicated are allowed using hashset (set only store unique values so duplecate ignored)
		System.out.println(new HashSet<>(map5.values()).equals(new HashSet<>(map6.values()))); //o/p= true
		System.out.println(new HashSet<>(map5.values()).equals(new HashSet<>(map7.values()))); //o/p= true
	}

}
