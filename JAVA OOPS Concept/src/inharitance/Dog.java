package inharitance;
// child class wants to access the property of parent class
public class Dog extends Animal{
 public static void main(String[] args) {
  Dog obj=new Dog();
	obj.sound();// first check his pocket
	obj.size(); // if extend not present then this shows error 
	// if we extend with parent animal class then it will run 
		
  Animal obj2=new Animal(); 
  // if we create parent class object then no need to extend 
	obj2.sound();//parent class obj always call parent class methods 
	obj2.size();	
	}
 public void sound()
	{
	System.out.println("C dog class sound");
	}

}
