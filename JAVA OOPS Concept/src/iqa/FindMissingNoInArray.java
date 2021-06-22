package iqa;

public class FindMissingNoInArray {

	public static void main(String[] args) {
		int a[]={1,2,4,5};
		//logic is add all values up to last digit 1+2+4+5=12, add all expected values = 1+2+3+4+5=15 , 
		//15-12= 3 is missing

		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum=sum+a[i];
		}
		System.out.println(sum);
		// sum of complete sequence
		int sum1=0;
		for (int j = 0; j <= 5; j++) {
			sum1=sum1+j;
		}
		System.out.println(sum1);
		System.out.println("missing no = " + (sum1-sum));
		
	}

}
