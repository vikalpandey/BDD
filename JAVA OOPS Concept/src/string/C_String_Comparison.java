package string;

public class C_String_Comparison {
	public static void main(String[] args) {
		//String Manipulation in Java - Interview questions - Part -7
		//https://www.youtube.com/watch?v=PaUwqAzom2Y&t=470s
		String s1="i am java programmer i am java";
		String s2="i am java programmer i am javA ; i";
		System.out.println(s1.equals(s2));// it return true / false(not ignore the lower/uppercase)
		System.out.println(s1.equalsIgnoreCase(s2));// it return true / false(ignore the lower/uppercase)
		System.out.println(s1==s2); //O/P= compare ref value (o/p is same as equal)
		
		
		//SubString
		System.out.println("find sub string= "+s1.substring(2));//O/p =find sub string= am java programmer i am java
		System.out.println(s1.substring(2, 9));//o/p= am java
		
		//Replace method
		System.out.println("replace fun = "+s2.replace(";", "replaced"));
		System.out.println("replace fun2 = "+ s2.replace("javA", "replaced"));
		String date="01-01-2020"; //conver to  "01/01/2020"
		System.out.println("date si replaced ="+date.replace("-", "/"));
		
		//concatinate (string can concatinated with any value)
		String x="hello";
		String y="world";
		int a=100;
		int b=200;
		System.out.println( x+y+a+b); //O/P= helloworld100200  
		System.out.println( x+y+(a+b)); //O/P= helloworld300
		System.out.println( a+b+x+y); //O/P= 300helloworld
		
		//split // return the array of string
		String str="hello_world_java_Selenium";
		String testval[]=str.split("_");  //now we got the array 
		//Printing all values of array like testval[0]=	hello,testval[1]= world] 
		for (int i = 0; i < testval.length; i++) {
			System.out.println(testval[i]);
		}
//		O/p= hello
//				world
//				java
//				Selenium
		
		//How to Reverse a String - Java Interview Question -1
		//https://www.youtube.com/watch?v=exzJoArl0h0
		
//1). how to Reverse string (reverse method not avaialble due to string immutable )
		String string="selenium";
		String st = "";
		for (int i = string.length()-1; i >=0; i--) {
			//System.out.println("reverse = "+string.charAt(i));
			 st=st+string.charAt(i);
		}
		 System.out.println(string +" reverse= "+ st);
		
		//2). how to Reverse string - using string buffer
		 StringBuffer sf=new StringBuffer(string);
		 StringBuffer stringreverse=sf.reverse();
		 System.out.println("string reverse using string buffer classs= "+stringreverse);
		 
		
		 
		 
		 
		
	}

}
