package p2;

public class methods {

	private int id;
	private String name;
	

	public void setid(int id) // setter method
	{
		this.id = id;
		System.out.println("setter method executed");
	}
	
	

	public int getid() // Getter method
	{
		System.out.println("getter method executed");
		return id;
	}

}
