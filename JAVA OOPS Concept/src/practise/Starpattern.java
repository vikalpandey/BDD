package practise;

import java.util.Iterator;

import org.apache.commons.math3.optim.linear.SolutionCallback;

public class Starpattern {
	//print increment order star pattern upto 5
	
	public static void main(String[] args) {
		Starpattern obj=new Starpattern();
	//	obj.printStarPatternInIncrementOrder();
	//	obj.printStarPatternInReverseOrder();
//		obj.starPatternIncreseAndDecress();
		
//		obj.StartPatternStartWithSpace();
//		System.out.println(".............");
//		obj.StartPatternStartWithSpace2();
		
		obj.pyramidPattern();
		


		
	}
	
	public void printStarPatternInIncrementOrder()
	{
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	public void printStarPatternInReverseOrder()
	{
		for(int i=0; i<=4; i++)
		{
			for(int j=4;j>=i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
			
	}
	
	public void starPatternIncreseAndDecress()
	{
		for (int i=0; i<= 4; i++) 
		{
			for(int j=0; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i=0; i<=4; i++)
		{
			for(int j=4;j>i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void StartPatternStartWithSpace()
	{
		for(int i=1; i<=4; i++)  // for 1st row
		{
			for (int j=3; j>=i; j--) {
				System.out.print(" ");
			}
			for (int k=1; k<=i ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void StartPatternStartWithSpace2()
	{
		for(int i=0; i<=4; i++)
		{
			for (int j = i; j <= 3; j++) {
				System.out.print(" ");
			}
			for (int k = i; k >=0 ; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void pyramidPattern()
	{
		for(int i=0;i<=4; i++)
		{
			for(int j=3;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++)
			{
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	
	
	
	
}
