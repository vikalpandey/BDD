package abstraction;

public class Chromdriver extends Webdriver {

 @Override
  public void click() {
   System.out.println("click chromedriver class");
		
	}

 @Override
  public void sendkeys() {
	System.out.println("send keys");
		
	}
	

}
