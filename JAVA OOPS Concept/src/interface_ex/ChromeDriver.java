package interface_ex;
public class ChromeDriver extends Parentclass1 implements Webdriver,RemoteWebDriver {
	@Override
	public void click() {
		System.out.println("click method");		}
	@Override
	public void sendkeys() {
		System.out.println("send keys method");	}
	@Override
	public void windowmaximize() {
		System.out.println("windowmaximize medthod");		}
public static void main(String[] args) {
	ChromeDriver obj=new ChromeDriver();
	obj.click();
	obj.sendkeys();
	obj.windowmaximize();    }



	

}
