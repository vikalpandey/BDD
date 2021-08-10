package practise;
public class Fib {
	
	public static void main(String[] args) {
		
//Method way 1	=> using while loop 	
		int i=1;
		int j=0, k=0;
while (i<100)
{
	i=i+j;
	System.out.print(i);
	System.out.print(", ");
	j=i-j;
}
System.out.println("");
System.out.println("------------//Method way 2	=> 	using for loop  ");
//Method way 2	=> 	using for loop 
int n1=0, n2=1, n3,a, count=15;
System.out.print(n1+" "+n2);
for (j=2;  j<count; ++j) {
	n3=n1+n2;
	System.out.print(" "+n3);
	n1=n2;
	n2=n3;
}
System.out.println("");
System.out.println("------------ //Method way 3	=> 	using Using Recursion");
//Method way 3	=> 	using Using Recursion

int N=12;
//Print the first N numbers
for (int z = 0; z < N; z++) {
	System.out.print(fib(z)+" ");
}


System.out.println("");
System.out.println("------------ //Method way 4	=> Using Dynamic Programming array");
//Method way 4	=> Using Dynamic Programming array





		
	}
	
	
	public static int fib(int n)
	{
		if(n<=1)
			return n;
		return fib(n-1)+fib(n-2);
		// n=2  1+0=1   n=5 4+3=7 
	}
	
	
	public static int fibArray(int n)
	{
		// Declare an array to store  Fibonacci numbers. 1 extra to handle case, n = 0
        int f[] = new int[n + 2];
        int i;
     // 0th and 1st number of the series are 0 and 1
        f[0] = 0;
        f[1] = 1;
  
        for (i = 2; i <= n; i++) {
  
            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }
  
        // Nth Fibonacci Number
        return f[n];
        
        
        
	}
	

}
