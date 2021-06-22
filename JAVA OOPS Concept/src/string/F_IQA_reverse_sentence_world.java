package string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class F_IQA_reverse_sentence_world {
	
	public static void main(String[] args) {
		F_IQA_reverse_sentence_world obj=new F_IQA_reverse_sentence_world();
		System.out.println("start ");
		obj.reverseWordInMyString("hi vikal pandey");  //o/p= ih lakiv yednap 
		obj.reverseWordInString("hello my india");  //o/p=  india my hello
		
		obj.reverseWordsOfString("i love my india"); //o/p= india my love i
		obj.reverseWordsOfString2("i am working in incedo here ");// result=  here incedo in working am i
		

		
		
		//Program to reverse a string entered by user
		String str;
		System.out.println("please enter your name for reverse");
		Scanner scanner=new Scanner(System.in);
		str = scanner.nextLine();
		scanner.close();
		
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
        //
        String s1="vikal";
        System.out.println(s1.substring(1)+s1.charAt(0));
////////

		
		
		
	}
	
	public void reverseWordInMyString(String str)
	{
		String  words[]=str.split(" ");
		System.out.println(Arrays.toString(words));
		System.out.println(words.length);
		String revstring ="";
		for (int i = 0; i < words.length; i++) {
			String word =words[i];
			System.out.println(word.length());
			String revword="";
			for (int j = word.length()-1; j  >=0; j--) {
				/* The charAt() function returns the character
				 * at the given position in a string
				 */
				revword=revword+word.charAt(j);
				System.out.println(revword);
			}
			revstring= revstring+revword +" ";
		}
		System.out.println(str);
		System.out.println(revstring);
		
	}
	
	public void reverseWordInString(String str)
	{
		//String str="hello my india";  //"india my hellow"
		String s1[]=str.split(" ");
		System.out.println(s1.length + ", "+Arrays.toString(s1));
		String revstring="";
		for (int i = s1.length-1; i >=0; i--) {
			String s2=s1[i];
			revstring=revstring+" " +s2;
			System.out.println(revstring);
		}
		System.out.println(revstring);
	}
	
	public static String reverseWordsOfString(String str)
	{
		
		// Specifying the pattern to be searched 
        Pattern pattern = Pattern.compile("\\s"); 
  
        // splitting String str with a pattern 
        // (i.e )splitting the string whenever their 
        //  is whitespace and store in temp array. 
        String[] temp = pattern.split(str); 
        String result = ""; 
  
        // Iterate over the temp array and store 
        // the string in reverse order. 
        for (int i = 0; i < temp.length; i++) { 
            if (i == temp.length - 1) 
                result = temp[i] + result; 
            else
            	//System.out.println(temp[i]);
                result = " " + temp[i] + result; 
           // System.out.println(result);
        } 
        System.out.println(result);
        return result; 
        
		
	}
	
	
	public static  String reverseWordsOfString2(String str1)
	{
		//String str1=" i am working in incedo";
		String temp[]  = str1.split(" ");
		System.out.println(Arrays.toString(temp));
		System.out.println("temp length = "+temp.length);
		String result="";
	       for (int i = 0; i < temp.length; i++) { 
	           
	            	//String result="";
	            	System.out.println(temp[i]);
	                result = " " + temp[i] + result; 
	                System.out.println(result);
	          
	        } 
		System.out.println("result= "+ result);
		return result;
	}
	
	
	
	
	
	
	
	public static String reverseString(String str)
	{
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
        
		
	}
	
	

}
