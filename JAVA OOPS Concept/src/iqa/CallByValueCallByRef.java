package iqa;

public class CallByValueCallByRef {
	//https://www.youtube.com/watch?v=mpFk7Vh8lHY      Naveen automation labs
	
	int p;
	int q;
	
	public static void main(String[] args) {
		
		CallByValueCallByRef obj=new CallByValueCallByRef();
		//obj.testSum(10, 20);
		int x=10;
		int y=20;
		obj.testSum(x, y); //Call by value or pass by value (Normal passing the parameter)
		/////////////////////////
		
		obj.p=50;  // we can call global variable using object
		obj.q=60;
		obj.swap(obj);  // Call by ref
		System.out.println(obj.p);
		System.out.println(obj.q);
		
		
	}
	
	public int testSum(int a, int b)
	{
		int c=a+b;
		return c;
	}
	//*****  Call by reference
	public void swap(CallByValueCallByRef t)
	{
		int temp;
		temp =t.p;  //temp=50
		t.p=t.q;    //t.p=60
		t.q=temp;   // t.q=50
	}
	

}
