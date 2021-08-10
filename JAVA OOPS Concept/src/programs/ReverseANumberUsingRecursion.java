package programs;

public class ReverseANumberUsingRecursion {
	// Reverse A Number using Recursion - Java Interview Question
	//https://www.youtube.com/watch?v=8dEe2-Pv4gU   Naveen 
	
	public static void rev(long number)
	{
		if(number< 10)
		{
			System.out.println(number);
			return;
		}
		else
		{
			System.out.print(number%10);
			rev(number/10);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		rev(123456);  //o/p= 654321
		rev(4);       //o/p= 4
		rev(1234566666666667890l); //o/p= 0987666666666654321  so that we use long here not int
		rev(001);  //o/p= 1 becasue of 001 = 1 only so consider 1 as input 
		rev(100);  //o/p=  001
		rev(0);   //o/p= 0
		
//		int num=123;
//		while(num>0)
//		{
//			int rev=num % 10;
//			System.out.print(rev);
//			num=num/10;
//		}
		
		
	}

}
