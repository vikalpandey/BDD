package abstraction;

public class Main {
	public static void main(String[] args) {
		
		//ChildChrome obj=new ChildChrome();
		Chromdriver obj= new Chromdriver();
		obj.click();
		obj.sendkeys();
		obj.gettitle();
	}

}
