package iqa;

public class CallByValueCallByRef2 {
	
	int data =50;
	
	 public static void main(String args[]){  
		 CallByValueCallByRef2 obj=new CallByValueCallByRef2();  
		  
		   System.out.println("before change "+obj.data);  
		   obj.change(500);  
		   System.out.println("after change "+obj.data); 
		   //////Call by ref
		   System.out.println("before change2 "+obj.data);  
		   obj.change2(obj);  //****passing object  
		   System.out.println("after change2 "+obj.data);  
		   
		 }  
	
	
	 void change(int data){  
		 data=data+100;//changes will be in the local variable only  
		 }  

	 void change2(CallByValueCallByRef2 obj){
		// data=data+100;  //OR both react same 
		 obj.data=obj.data+100;//changes will be in the instance variable  
	 }
	 
	 
}
