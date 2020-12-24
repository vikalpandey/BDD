package interface_ex;
public class ChromeDriver extends Parentclass1 implements Webdriver,RemoteWebDriver {
	public static int num = 10000;
	@Override
	public void click() {
		System.out.println("click method of chrome driver class");		}
	@Override
	public void sendkeys() {
		System.out.println("send keys method of chrome driver class");	}
	@Override
	public void windowmaximize() {
		System.out.println("windowmaximize medthod of chrome driver class");		}
	public void getcurrenturl()	{
		System.out.println("get current url method"); 	}
	
public static void main(String[] args) {
	
	ChromeDriver obj=new ChromeDriver();
	obj.click();  //o/p= click method of chrome driver class
	obj.sendkeys(); //o/p= send keys method of chrome driver class
	obj.windowmaximize();    //o/p= windowmaximize medthod of chrome driver class
	obj.getcurrenturl();  //O/p= get current url method
	System.out.println(Webdriver.num); //O/p=100
	System.out.println(obj.num);  //O/p=10000
	//Webdriver.num=200;   //Compile time error 
	
	Webdriver obj2=new ChromeDriver();
	obj2.click();  // only overiddden method will be called 
	obj2.sendkeys();
	System.out.println(obj2.num); //O/p=100
	

} 



	

}
