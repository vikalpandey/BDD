package iqa;

public class LocalVsGlobalVariable {
	//Global variable,, Class variable
	String name="Vikal Pandey";
	int age=25;
	
	public static void main(String[] args) {
		int i=10; //local variable
		System.out.println(i); //O/P=10
		//System.out.println(name);  //showing error and suggest that 
		LocalVsGlobalVariable obj=new LocalVsGlobalVariable();
		obj.sum(); // for calling global variable we have to create object 
		System.out.println(obj.name); //Access global variable through object
		System.out.println(obj.age);
	}

	public void sum()
	{
		System.out.println("global variable name= "+name);
		System.out.println("global variable age= "+age);
	}
}
