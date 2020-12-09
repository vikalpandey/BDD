package Stepimplementions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Util.TestBase;

public class Dashboard extends TestBase {

	By paystubtile = By.xpath("//input[@id='UserName']");

	// 1= validate emp current url
	public void validate_emp_dashboard_currenturl() {
		String expeted_emp_dashboardurl = "http://avitusnetdev.incedoinc.com:82/DashBoard/Employee#";
		log.info("method started validate_emp_dashboard_currenturl");
		String actual_emp_dashboardurl = driver.getCurrentUrl();
		System.out.println("actual_emp_dashboardurl = " + actual_emp_dashboardurl);
		Assert.assertEquals(actual_emp_dashboardurl, expeted_emp_dashboardurl,
				"VP_Fail-: emp current url is not matching ");
	}

	// 1.1= validate CA current url
	public void validate_ca_dashboard_currenturl() {
		String expeted_ca_dashboardurl = "http://10.12.0.94:82/DashBoard/Clientadmin";
		String actual_ca_dashboardurl = driver.getCurrentUrl();
		System.out.println("actual_ca_dashboardurl = " + actual_ca_dashboardurl);
		Assert.assertEquals(actual_ca_dashboardurl, expeted_ca_dashboardurl,
				"VP_Fail-: CA current url is not matching ");
	}

	// 1.2= validate SA current url
	public void validate_sa_dashboard_currenturl() {
		String expeted_sa_dashboardurl = "http://10.12.0.94:82/DashBoard/Systemadmin";
		String actual_sa_dashboardurl = driver.getCurrentUrl();
		System.out.println("actual_sa_dashboardurl = " + actual_sa_dashboardurl);
		Assert.assertEquals(actual_sa_dashboardurl, expeted_sa_dashboardurl,
				"VP_Fail-: SA current url is not matching ");
	}

	// 2= validate employee paystub tile text
	public void validate_emp_Paystub_tiletext() {
		System.out.println("getiing actual text of paystub tile  ");
		String actul_paystub_text = driver.findElement(By.xpath("//*[contains(text(), 'Pay Stubs (')]")).getText();
		String expectedpaystubtext = "Pay Stubs (";
		System.out.println("start assert & actul_paystub_text=  " + actul_paystub_text);
		Assert.assertTrue(actul_paystub_text.contains(expectedpaystubtext),
				"VP_Fail-: emp dahboard paystub tile text not matched");
		System.out.println("end paystub assert  ");
	}

	// 3= validate employee pto summary tile text
	public void validate_emp_Ptosummary_tiletext() {
		System.out.println("getiing actual text of pto summary tile  ");
		String actul_ptosummary_text = driver.findElement(By.xpath("//*[contains(text(), 'PTO Summary (')]")).getText();
		String expectedptosummarytext = "PTO Summary (";
		System.out.println("start assert & actul_ptosummary_text=  " + actul_ptosummary_text);
		Assert.assertTrue(actul_ptosummary_text.contains(expectedptosummarytext),
				"VP_Fail-: emp dahboard pto summary tile text not matched");
		System.out.println("end pto summary assert  ");
	}

	// 4= validate employee document tile text
	public void validate_emp_Document_tiletext() {
		System.out.println("getiing actual text of document tile  ");
		String actul_document_text = driver.findElement(By.xpath("//*[contains(text(), 'Documents (')]")).getText();
		String expecteddocumenttext = "Documents (";
		System.out.println("start assert & actul_document_text=  " + actul_document_text);
		Assert.assertTrue(actul_document_text.contains(expecteddocumenttext),
				"VP_Fail-: emp dahboard document tile text not matched");
		System.out.println("end document assert  ");
	}

	// 4= validate employee Announcements tile text
	public void validate_Announcements_tiletext() {
		System.out.println("getiing actual text of Announcements tile  ");
		String actul_Announcements_text = driver.findElement(By.xpath("//*[contains(text(), 'Announcements (')]"))
				.getText();
		String expectedAnnouncementstext = "Announcements (";
		System.out.println("start assert & actul_Announcements_text=  " + actul_Announcements_text);
		Assert.assertTrue(actul_Announcements_text.contains(expectedAnnouncementstext),
				"VP_Fail-: emp dahboard Announcements tile text not matched");
		System.out.println("end Announcements assert  ");
	}

	// 5= validate employee quick link - Banking quick link is present or not
	public void validate_emp_Banking_Quicklinktext() {
		System.out.println("quick link -View Banking Details displaying or not   ");
		String actul_banking_text = driver.findElement(By.xpath("//a[contains(text(), 'View Banking Details')]"))
				.getText();
		String expectedbankingtext = "View Banking Details";
		System.out.println("start assert & actul_banking_text=  " + actul_banking_text);
		Assert.assertTrue(actul_banking_text.contains(expectedbankingtext),
				"VP_Fail-: emp dahboard quick banking text not matched");

		WebElement banking_text = driver.findElement(By.xpath("//a[contains(text(), 'View Banking Details')]"));
		Assert.assertTrue(banking_text.isDisplayed());
		System.out.println("end Banking assert  ");
	}

	// 6= validate CA Invoice tile text
	public void validate_CA_Invoice_tiletext() {
		System.out.println("getiing actual text of Invoice tile  ");
		String actul_Invoice_text = driver.findElement(By.xpath("//*[contains(text(), 'Invoices (')]")).getText();
		String expectedInvoicetext = "Invoices (";
		System.out.println("start assert & actul_Invoice_text=  " + actul_Invoice_text);
		Assert.assertTrue(actul_Invoice_text.contains(expectedInvoicetext),
				"VP_Fail-: CA dahboard invoice tile text not matched");
		System.out.println("end invoice assert  ");
	}

	// 7= validate SA Change Request tile text
	public void validate_SA_Change_Request_tiletext() {
		System.out.println("getiing actual text of Change Request tile  ");
		String actul_CR_text = driver.findElement(By.xpath("//*[contains(text(), 'Change Request (')]")).getText();
		String expectedCRtext = "Change Request (";
		System.out.println("start assert & actul_CR_text=  " + actul_CR_text);
		Assert.assertTrue(actul_CR_text.contains(expectedCRtext),
				"VP_Fail-: CA dahboard Change Request tile text not matched");
		System.out.println("end Change Request assert  ");
	}

	// 8= validate SA Time Sheet tile text
	public void validate_SA_Time_Sheet_tiletext() {
		System.out.println("getiing actual text of Time sheet tile  ");
		String actul_Time_Sheet_text = driver.findElement(By.xpath("//*[contains(text(), 'Time Sheet (')]")).getText();
		String expectedTime_Sheettext = "Time Sheet (";
		System.out.println("start assert & actul_Time_Sheet_text=  " + actul_Time_Sheet_text);
		Assert.assertTrue(actul_Time_Sheet_text.contains(expectedTime_Sheettext),
				"VP_Fail-: CA dahboard Time sheet tile text not matched");
		System.out.println("end Time sheet assert  ");
	}

}
