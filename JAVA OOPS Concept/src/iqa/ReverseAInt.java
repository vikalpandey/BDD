package iqa;

public class ReverseAInt {

	public static void main(String[] args) {
	//using algo	
		long num=1234567890;   //o/p=987654321
		long rev=0;
		
		while (num!=0) {
			rev=rev*10 + num % 10;   //5,    //54   //543  //5432  //54321
			num=num/10;              //1234  //123  //12  //1  

		}
		System.out.println("reverse no is = "+rev);

	//2. using string buffer method
		long num1=123456;
		System.out.println(new StringBuffer(String.valueOf(num1)).reverse());
		
		
		
	}

}
