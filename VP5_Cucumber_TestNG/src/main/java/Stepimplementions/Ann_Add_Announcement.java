package Stepimplementions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Util.Common;
import Util.TestBase;

public class Ann_Add_Announcement extends TestBase {
	Goto go=new Goto();
	
	By announcmentcheckbox=By.xpath("//input[@id='chkAnnouncement']");
	By TargetAudienceDropDown=By.xpath("//select[@id='NewsBroadcastToValue']");
	
	
	
	public void CheckAnnouncementCheckbox()
	{
		driver.findElement(announcmentcheckbox).click();

	}
	
	public void SelectTargetAudienceDropDownAsEmp()
	{
		driver.findElement(TargetAudienceDropDown).isDisplayed();
		WebElement element=driver.findElement(TargetAudienceDropDown);
		Common.isElementPresent(element);
		
		Select select=new Select(element);
		select.selectByVisibleText("Employees");
		
		List<WebElement> dlist=driver.findElements(By.xpath("//*[@id='NewsBroadcastToValue']/option"));
		System.out.println("dropdow list size= "+dlist.size());
		for (WebElement delement : dlist) {
			System.out.println("dropdow list== "+delement.getText());
		}
		//or you can use another way just like ** more Better than previous
//		WebElement dropdown=driver.findElement(TargetAudienceDropDown);
//		List<WebElement> dlist1=dropdown.findElements(By.tagName("option"));
//		System.out.println("dropdow list size= "+dlist1.size());
//		for (WebElement delement : dlist1) {
//			System.out.println("dropdow list== "+delement.getText());
//		}
//		
		
	
		
	}
	
	
	
	
	
	
	
}
