package string;

import java.util.HashMap;
import java.util.Iterator;

public class E_IQA_Duplicate_occourance_word {
	public static void main(String[] args) {
		String str="i am am learning java java";
		findDuplicateWord(str);
		String str1="abccdd";
		findDuplicateChar(str1);
	}
	
	public static void findDuplicateWord(String str)
	{
		HashMap<String, Integer> hm = new HashMap<>();
		String s[] =str.split(" ");
		for (String tempstring : s) {
			if (hm.get(tempstring)!=null) {
				hm.put(tempstring, hm.get(tempstring)+1);
			}
			else {
				hm.put(tempstring, 1);
			}
		
		}
		//System.out.println(hm);
		// to view duplicates we need to chacke each key value > 1
		Iterator<String> tempString=hm.keySet().iterator();
		while (tempString.hasNext()) {
			String temp=tempString.next();
			if (hm.get(temp)>1) {
				System.out.println("the world "+ temp +" appeared "+hm.get(temp)+" no of times");
			}
		}	
	}
	
	public static void findDuplicateChar(String str)
	{
	HashMap<Character, Integer>  hm=new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			if (hm.get(c) != null ){
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		//System.out.println(hm);
		// to view duplicates we need to chacke each key value > 1
		Iterator<Character> tempString2=hm.keySet().iterator();
		while (tempString2.hasNext()) {
			Character temp=tempString2.next();
			if (hm.get(temp)>1) {
				System.out.println("the Charcter "+ temp +" appeared "+hm.get(temp)+" no of times");
			}
		}
	}
	

}
