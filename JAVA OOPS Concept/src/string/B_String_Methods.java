package string;

import programs.Find_no_of_char_in_string;

public class B_String_Methods {
	
	public static void main(String[] args) {
		String s="i am java programmer i am java";
			System.out.println("length of a string = "+s.length());// O/P=30
			System.out.println("character at 3rd index= "+s.charAt(3));
			System.out.println(" 1st occourance of m or  what is the index of m= "+ s.indexOf("m"));
			System.out.println(" 2nd occourance of m   = "+s.indexOf("m", 9));
			System.out.println(" 2nd occourance of m   = "+s.indexOf("m", s.indexOf("m")+1));
			//System.out.println(" 3nd occourance of m   = "+s.indexOf("m", s.indexOf("m")+1));

			System.out.println("Print methods output="+ findNthOccurrenceOfACharacter(s, 'm', 4) );

		//Program for find 3rd occourance of any char in string	
			int count =0;
			for (int i = 0; i < s.length(); i++) {
				char ch=s.charAt(i);
				//System.out.println(ch);
				if (ch == 'm') {
				//System.out.println("m is available at index ="+ i );
				count =count+1;
				//System.out.println("count = "+count);
				if (count ==4) {
					System.out.println("4rd occourance of m index= "+ i);
				}
				}
			}
			
			System.out.println(" 1st occourance of java= "+ s.indexOf("java"));
			System.out.println(" 1st occourance of any word which is not available= "+ s.indexOf("zzz"));// O/p=-1
			// this is very useful when you find any label or string in apge and its return -1 means element not present
			System.out.println("2nd occourence of java= "+s.indexOf("java", s.indexOf("java")+1) );

		
		
		
	}
	
	public static int findNthOccurrenceOfACharacter(String str, char ch, int N)
	{
		int count = 0; 
	    // Loop to find the Nth 
	    // occurence of the character 
	    for (int i = 0; i < str.length(); i++)    { 
	        if (str.charAt(i) == ch)  { 
	            count += 1; 
	        } 
	        if (count == N) 
	            return i; 
	    } 
	    return -1; 
	}

	
	

}
