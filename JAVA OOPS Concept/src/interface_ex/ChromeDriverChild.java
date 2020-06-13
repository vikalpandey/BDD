package interface_ex;

public class ChromeDriverChild extends ChromeDriver {
	
	public static void main(String[] args) {
		
		ChromeDriverChild obj=new ChromeDriverChild();
		obj.click();
		obj.sendkeys();
		obj.windowmaximize();
	}
	

}
