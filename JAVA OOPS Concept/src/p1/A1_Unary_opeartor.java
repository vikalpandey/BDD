package p1;

public class A1_Unary_opeartor {
	public static void main(String[] args) {
		//   ++	Increment operator; increments value by 1
		//   --	decrement operator; decrements value by 1
		
//		int g=10;
//		int h=g++ ;
//		System.out.println(h);
//		int o=10;
//		int p=++o;
//		System.out.println(p);
		System.out.println("- concept-https://www.youtube.com/watch?v=Ep_Qkcailrw-----------");
		
		int g=10;
		int h=  ++g + g++;
		System.out.println(g + " " +h);
		//4 6
		System.out.println("-----++a will not work for constant--------");
		//final int a=10;
		//int b= a++;
		//System.out.println(b);
		//    O/P= error: cannot assign a value to final variable a
		
		
		System.out.println("-------------");
		int x=10;
				System.out.println(x++);//10
				System.out.println(++x); //12
				System.out.println(x--);//12
				System.out.println(--x);//10
				System.out.println("------Example -------");
				int i=10;
//				System.out.println(i++);
//				System.out.println("value of i++ ="+ i);
//				System.out.println(++i);
//				System.out.println("value of ++i ="+ i);
				System.out.println( i++ + ++i);
				int j =i++;
				System.out.println("value of j ="+j);
				int k=++i;
				System.out.println("value of k ="+k);
				
				
				System.out.println("-------------");
//				
//				System.out.println(+x);//10
//				System.out.println(-x);//-10
//	            System.out.println(~x);//-11
//	        	System.out.println("-----a, b --------");
//	            int m=10;  
//	            int n=10;  
//	            System.out.println(m++ + ++m);//10+12=22  
//	            System.out.println(n++ + n++);//10+11=21  
//				
//	            System.out.println("-----Java Unary Operator Example:    ~ and !--------");
//	            //     !	Logical complement operator; inverts the value of a boolean
//	            
//	            int a=10;  
//	            int b=-10;  
//	            boolean c=true;  
//	            boolean d=false;  
//	            System.out.println(~a);//-11 (minus of total positive value which starts from 0)  
//	            System.out.println(~b);//9 (positive of total minus, positive starts from 0)  
//	            System.out.println(!c);//false (opposite of boolean value)  
//	            System.out.println(!d);//true  
//
//	            System.out.println("-----Left Shift Operator  The Java left shift operator << is used to "
//	            		+ "shift all of the bits in a value to the left side of a specified number of times--------");
//	
//	            System.out.println(10<<2);//10*2^2=10*4=40  
//	            System.out.println(10<<3);//10*2^3=10*8=80  
//	            System.out.println(20<<2);//20*2^2=20*4=80  
//	            System.out.println(15<<4);//15*2^4=15*16=240  
	            
	            
	
	}

}
