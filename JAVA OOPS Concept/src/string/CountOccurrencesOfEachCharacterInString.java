package string;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountOccurrencesOfEachCharacterInString {
	public static void main(String[] args) {
		getCharCount("abbcccdddd effggg");  //o/p = abbcccdddd effggg : { =1, a=1, b=2, c=3, d=4, e=1, f=2, g=3}
		getCharCount("  "); //o/p =    : { =2}  but if you want to exclude space then add 1 condition if(!String.valueOf(c).contains(" " )) 
	getSingleCharCount("abbccc", 'c');
//	given string = abbccc : {a=1, b=2, c=3}
//	count of char  c = 3
	
	getduplicatechar("abbccc");
//	o/p= given string = abbccc : {a=1, b=2, c=3}
//	the Charcter b appeared 2 no of times
//	the Charcter c appeared 3 no of times
	
	getduplicateword("vikal pandey vikal"); 
	// o/p =  given string = vikal pandey vikal : {pandey=1, vikal=2}
	//         the Charcter vikal appeared 2 no of times
	}
	
	public static void getCharCount(String name)
	{
		Map<Character, Integer> charmap=new HashMap<Character, Integer>();
		char strArray[]=name.toCharArray();         // it return one Character array
		for (char c : strArray) {	
			if(!String.valueOf(c).contains(" " ))   //or use .isBlank method
			{
				if(charmap.containsKey(c))
				{
					charmap.put(c, charmap.get(c)+1); //charmap.get(c)  return value of eixting char
				}
				else
				{
					charmap.put(c, 1);
				}
			}
		}	
		System.out.println(name +" : "+ charmap);
	}
	
	

	public static void getSingleCharCount(String name, char z)
	{
		Map<Character, Integer> charmap=new HashMap<Character, Integer>();
		char strArray[]=name.toCharArray();         // it return one Character array
		for (char c : strArray) {	
		
			if(charmap.containsKey(c))
			{
				charmap.put(c, charmap.get(c)+1); //charmap.get(c)  return value of eixting char
			}
			else
			{
				charmap.put(c, 1);
			}
		}	
		System.out.println("given string = "+name +" : "+ charmap);
		System.out.println("count of char  "+z +" = "+charmap.get(z));
	}
	public static void getduplicatechar(String name)
	{
		Map<Character, Integer> charmap=new HashMap<Character, Integer>();
		char strArray[]=name.toCharArray();         // it return one Character array
		for (char c : strArray) {	
			if(!String.valueOf(c).contains(" " ))   //or use .isBlank method
			{
				if(charmap.containsKey(c))
				{
					charmap.put(c, charmap.get(c)+1); //charmap.get(c)  return value of eixting char
				}
				else
				{
					charmap.put(c, 1);
				}
			}
		}	
		System.out.println("given string = "+name +" : "+ charmap);
		// to view duplicates we need to chacke each key value > 1
		Iterator<Character> itrTempString=charmap.keySet().iterator();
		while(itrTempString.hasNext())
		{
			Character temp=itrTempString.next();
			if(charmap.get(temp)>1)
			{
				System.out.println("the Charcter "+ temp +" appeared "+charmap.get(temp)+" no of times");
			}	
		}	
	}
	
	public static void getduplicateword(String name)
	{
		Map<String, Integer> hm=new HashMap<String, Integer>();
		String s[] =name.split(" ");  // split and store in string array
		
		for (String tempstring : s) {
			if (hm.get(tempstring)!=null) {
				hm.put(tempstring, hm.get(tempstring)+1);
			}
			else {
				hm.put(tempstring, 1);
			}
		}
		
		System.out.println("given string = "+name +" : "+ hm);
		// to view duplicates we need to chacke each key value > 1
		Iterator<String> itrTempString=hm.keySet().iterator();
		while(itrTempString.hasNext())
		{
			String temp=itrTempString.next();
			if(hm.get(temp)>1)
			{
				System.out.println("the Charcter "+ temp +" appeared "+hm.get(temp)+" no of times");
			}	
		}	
	}
	
	
}
