package string;

public class D_SwapingOf_StringVariable {
	
	public static void main(String[] args) {
		//How to swap two integer without using temp or 3rd variable and using + operator
		int x =2;
		int y =3;
		 x=x+y;
		 y=x-y;
		 x=x-y;
		// System.out.println("x= "+x +" and y=  "+ y); //o/P= x= 3 and y=  2

		// using  using * operator
		x=x*y;
		y=x/y;
		x=x/y;
		System.out.println("x= "+x +" and y=  "+ y); //o/P= x= 3 and y=  2
		//https://www.youtube.com/watch?v=c1n_4JjfohA
//Swap two Strings without using temp/third variable - Java Interview Questions -9
		String s1= "hello";
		String s2= "world";
		s1=s1+s2;
		System.out.println("value of s1= " + s1);
		s2=s1.substring(0, s1.length()-s2.length());
		s1=s1.substring(s2.length());
		System.out.println("value of s1= "+ s1 +",  and  value of s2= "+ s2);
		
		//https://www.youtube.com/watch?v=z_Cys4W3OOk
		//How to Verify if the String Contains only Digits || Java Interview Question
		
		
		System.out.println(isNumeric(null));
		System.out.println(isNumeric(""));
		System.out.println(isNumeric(" "));
		System.out.println(isNumeric("a"));
		System.out.println(isNumeric("123a"));
		System.out.println(isNumeric("1")); //true
		System.out.println(isNumeric("1.1"));//false
		System.out.println(isNumeric("+11"));//false
		System.out.println(isNumeric("-11"));  //false
		System.out.println(isNumeric("0"));  //true
		System.out.println("unicode value= "+isNumeric("\u0967\u0968\u0969"));  //O/P=true
		
		//Remove Junk/Special Chars in a String - Java Interview Questions -2
		//https://www.youtube.com/watch?v=rLmA3Y-9nuM
		
		String str="Hel*^% lo  %^ 1 23 !@#$%^&*(";
		// use regular expression use   [^a-zA-Z0-9]    //^  = not
		
		str=str.replaceAll("[^a-zA-Z0-9 ]", "");  // if we give space in reg exp then it will not remove space
		System.out.println("removed all special and junk char & remaining char = "+str);// O/P= = Hel lo   1 23 
		
		
		
		
		
		
		
		
	}
	
	
	public static boolean isEmpty ( CharSequence cs)
	{
		return cs==null || cs.length()==0;
	}
	
	public static boolean isNumeric(CharSequence cs)
	{
		if(isEmpty(cs)){
			return false;
		}
		
		int length= cs.length();
		for (int i = 0; i < length; i++) {
			if (! Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
