package collection_Naveen20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arrylist_compare {
	public static void main(String[] args) {
		//1. using sorting then equals:
		ArrayList<String> l1=new ArrayList<String>(Arrays.asList("A","B","C","D","F"));
		
		ArrayList<String> l2=new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		ArrayList<String> l3=new ArrayList<String>(Arrays.asList("B","A","C","D","F"));
		//sort the arraylist - use collection class
		Collections.sort(l1);
		Collections.sort(l2);
		Collections.sort(l3); // l1 &l3 both are same but on compare result=false so that sort
		
		System.out.println(l1.equals(l2));  // o/p= false
		System.out.println(l1.equals(l3));  // o/p= true
		
		//2. compare two list =find out additional elements
		ArrayList<String> l4=new ArrayList<String>(Arrays.asList("A","B","C","D","F"));
		
		ArrayList<String> l5=new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		//l4.removeAll(l5);
		//System.out.println(l4);  // o/p=F
		
		//3 . find out missing element
		l5.removeAll(l4);
		System.out.println(l5); // o/p=E
		
		//4 find out common elements
		ArrayList<String> lang1=new ArrayList<String>(Arrays.asList("C","C++","Java",".net","phython"));
		ArrayList<String> lang2=new ArrayList<String>(Arrays.asList("C","C++","php",".net","phython"));
		lang1.retainAll(lang2);
		System.out.println(lang1); //O/p= [C, C++, .net, phython]
		
		
		
		
	}

}
