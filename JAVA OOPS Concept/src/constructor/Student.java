package constructor;
public class Student {
	String name;
	int rollno;
	public Student()
	{		System.out.println("calling construcror");	}
	
	public Student(int i)
	{		System.out.println(i);	}
	
	public Student(String name, int rollno)
	{
		//new Student(); or   this(); // for calling the default constructor
		//this();
		this(10);
		this.name=name;
		this.rollno=rollno;
	}
	public static void main(String[] args) {
		Student obj=new Student("vikal", 1234);
		System.out.println(obj.name);
		System.out.println(obj.rollno);
		

		
		
	}
	
	


}
