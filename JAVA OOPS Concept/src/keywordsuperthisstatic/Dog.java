package keywordsuperthisstatic;
public class Dog extends Animal {
	public Dog(int x)
	{
	System.out.println("Dog Cons");
	}
	
	public void sound()
	{
		super.sound();
		System.out.println("Dog sound method");
	}

}
