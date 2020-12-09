package Runner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class) // this is for junit 
@CucumberOptions(
		// you can also define the name of scenario using name  test it 
		//features="classpath:Features/Goto_all_pages.feature", 
				features="classpath:Features ", // i am using @vikal tag for running perticular feature
		//features="E:/2 Selenium/Z Eclipse new Java/VP5_Cucumber_TestNG/src/main/java/Features/E_Employee_MyDetails.feature",
		glue={"Stepdefinitions"},// path of step def files (where is yr stepdef file)
		
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},// Extent report plugin
		strict=false,    // it will check if any step is not defined in stepdef file  
		monochrome = true, // display the console output in readable format 
		tags = {"@vikal"},// @smoketest,@Regressiontest -- execute all test which are tagged as @smaketest OR @regressiontest
		//OR : tags={@smoketest, @regressiontest} -- execute all test tagged as @smoketest OR @regressiontest 
		//AND : tags={"@smoketest", "@regressiontest"} -- execute all test tagged as @smoketest AND @regressiontest 
		// ~ if you want to ignore any tag then use this special char before  tag as tags={~@smoketest, @regressiontest}
		dryRun=false   //true //it will check mappingbw feature file & step def file ,all steps are mapped with step def file or not
		
		
		)
	
public class TestRunner {
	
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	      //it will run at the starting point only of runner
	    }
	 
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	     // whole feature file will run inside this method - this methos start then feature start then feature end then this method end
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	    	//it will run at the start time of the runner
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();  
	      //it will run at the end point only of runner
	    }
	    //Below url have same runner
	//https://medium.com/agile-vision/cucumber-bdd-part-2-creating-a-sample-java-project-with-cucumber-testng-and-maven-127a1053c180
}





//
//***********@BeforeClass(alwaysRun = true) ,      public void setUpClass() 
//***********  @DataProvider        public Object[][] features 

//feature 1             Google 1 scenario 
//*****Start**********@Test public void feature(CucumberFeatureWrapper  
//		hooks Before method
//		Hooks after method
//*****End**********@Test public void feature(CucumberFeatureWrapper  


//feature2              home page 2 scenario
//*****Start**********@Test public void feature(CucumberFeatureWrapper 
//hooks Before method
//Hooks after method
//hooks Before method
//Hooks after method
//******end ***** @Test(groups = cucumber ,       public void feature  

//feature 3              home page 2 scenario
//*****Start**********@Test public void feature(CucumberFeatureWrapper  
//hooks Before method
//Hooks after method
//hooks Before method
//Hooks after method
//*****End**********@Test public void feature(CucumberFeatureWrapper  
//
//
//
//*********** @AfterClass(alwaysRun = true)      public void tearDownClass()


