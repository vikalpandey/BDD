package collection_Naveen20;

public class A_Test_HomePage {
	public static final String  homepageResources; 
	public static String homePageLink= "epam.com";
	
	static{
		homepageResources="home page  resources initialized";
		System.out.println(homepageResources);
	}
	public static void openPage()
	{
		System.out.println("Open Page = "+ homePageLink);
	}

}
