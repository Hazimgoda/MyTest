package Elemnus;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BasicTest {
	@Test(priority=4)
	public void Sum()
	{
		System.out.println("SumS");
		int a=9;
		int b=100;
		Reporter.log("Hello Hazim SUM");
		Assert.assertEquals(109, a+b);
	}
	
	@Test(dependsOnMethods="Sum",priority=1,description="this is multiply")
	public void Multi()
	{
		System.out.println("Milti");
		int a=10;
		int b=100;
		Reporter.log("Hello Hazim Multi");
		Assert.assertEquals(1000, a*b);
	}
	
	@Test(priority=2)
	public void Divide()
	{
		System.out.println("Div");
		int a=100;
		int b=10;
		Reporter.log("Hello Hazim Div");
		Assert.assertEquals(10, a/b);
	}
	
	@Test(priority=3)
	public void Minus()
	{
		System.out.println("Min");
		int a=10;
		int b=100;
		Reporter.log("Hello Hazim Min");
		Assert.assertEquals(90, b-a);
	}
@AfterTest
public void RunMyTest()
    {
	Reporter.log("Haz Finish");
	//LicenseKey.loadLicenseFile("C:\\Users\\ks\\eclipse-workspace9\\Maven\\target\\surefire-reports\\testng-results.xml");
	
	
	
	}
}
