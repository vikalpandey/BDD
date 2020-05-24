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
		//features="classpath:Features/E_Employee_MyDetails.feature", // path of feature for run only 1 feature file 
		//features="E:/2 Selenium/Z Eclipse new Java/VP5_Cucumber_TestNG/src/main/java/Features/E_Employee_MyDetails.feature",
		glue={"Stepdefinitions"},// path of step def files
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},// Extent report plugin
		strict=false,    // it will check if any step is not defined in stepdef file  
		monochrome = true, // display the console output in readable format 
		tags = {"@vikal"},// @smoketest,@Regressiontest -- execute all test whic are tagged as @smaketest OR @regressiontest
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
	    }
	 
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();        
	    }
	
}
