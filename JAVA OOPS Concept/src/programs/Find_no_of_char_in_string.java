package programs;

public class Find_no_of_char_in_string {
	
	public static void main(String[] args) {
		System.err.println("System.err.println");
		System.out.println("Main methods");
		
		String s="abcd ab a";
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			//System.out.print(s.charAt(i));
			//System.out.println(count=count+1);
			
			if (s.charAt(i)=='a')  {
					count++;
			}
			
		
			
		}
		System.out.println(count);
		
	}
	

}
