package collection_Naveen20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Arraylist_remove_dulicate {
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,4,5,7,8,3,6,7,7));
		//1. Linkedhashset
		LinkedHashSet<Integer> linkedhashset =new LinkedHashSet<Integer>(numbers);
	//	HashSet<Integer> hashset =new HashSet<Integer>(numbers);
		ArrayList<Integer> numberslistwithouduplicates=new ArrayList<Integer>(linkedhashset);
		System.out.println(numberslistwithouduplicates);
		
		//2. JDK 8 -Streams
		ArrayList<Integer> markslist=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,7,8,3,6,1));
		List<Integer> markslistunique=markslist.stream().distinct().collect(Collectors.toList());
		System.out.println(markslistunique);	
	
	}

}
