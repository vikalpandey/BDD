package iqa;

import java.util.Arrays;

public class HowFindLargestSmalestIntInArray {

	public static void main(String[] args) {
		
		int number[]={-10,-5, 0,1,2,6,30,80,101,99999};
		
		int largest=number[0];
		int smallest=number[0];
		
		for (int i = 1; i < number.length; i++) {
			if (number[i]>largest) {
				largest=number[i];
			}
			else if (number[i]<smallest) {
				smallest=number[i];
			}
		}
		System.out.println("\n given array is "+Arrays.toString(number));
		
		System.out.println("largest number is = "+ largest);
		System.out.println("largest number is = "+ smallest);

	}

}
