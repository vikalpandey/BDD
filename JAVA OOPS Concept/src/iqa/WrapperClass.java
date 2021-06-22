package iqa;

public class WrapperClass {

	public static void main(String[] args) {
		String s="100";
		System.out.println(s+20); //O/P= 10020
		//Data conversion string to int
		int i=Integer.parseInt(s); 
		System.out.println(i+20); //O/P= 120
		String s0="100a";   //Varchar value  (interview Question )
		int i1=Integer.parseInt(s0);
		System.out.println(i1+10); //O/P= NumberFormatException:
		//Data conversion string to double
		String s1="10.11";
		System.out.println(s1+20); //O/P= 10.1120
		double d=Double.parseDouble(s1);
		System.out.println(d+20); //O/P= 30.11
		
		//String to boolean
		String k="True";
		System.out.println(k); //O/P= True
		boolean b=Boolean.parseBoolean(k);
		System.out.println(k);  //O/P= True
		
		//int to String 
		int j=200;
		System.out.println(j+20); //O/P= 220
		String ss=String.valueOf(j);
		System.out.println(ss+20); //O/P= 20020
	
	
		
		
		
	}
	
	
	
	
}
