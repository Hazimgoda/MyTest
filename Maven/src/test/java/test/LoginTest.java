package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageFactory.GoogleLogin;
import org.testng.Reporter;
//import Pages.HomePage;

public class LoginTest {
	 WebDriver driver;

	 GoogleLogin objLogin;
	
	 @BeforeTest

	    public void setup() throws InterruptedException{
		 System.setProperty("webdriver.gecko.driver", ".\\MyDrivers\\geckodriver.exe"); 

	        driver = new FirefoxDriver();
	        Thread.sleep(2000);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://play.google.com/");

	    }
	 @Test(priority=1)

	    public void testSignIn() throws InterruptedException{
		 Thread.sleep(2000);
		 objLogin =new GoogleLogin(driver);
		 //Click on The Sign In Button
	    objLogin.ClickOnSignIn();
	    Reporter.log("Sign In");
	 }
	 @Test(priority=2)

	    public void TestLoginUser() throws InterruptedException{

	    //Write The User Name

	    objLogin.loginWithUserName("hazimgoda83@gmail.com");

	    // go the next page
	    objLogin.clickNext_User();
	   
	    //Verify User title
         Thread.sleep(2000);
	    String loginUserTitle = objLogin.getUserTitle();

	    Assert.assertTrue(objLogin.userTitleIsDisplayed());
	   // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        Reporter.log("User has been loged as : " + objLogin.getUserTitle());
	    }
	 @Test(priority=3)
	    public void TestLoginPassword() throws InterruptedException{

		    //Write The Password
		 Thread.sleep(3000);

		    objLogin.loginWithPassword("Hgvplk@hgvpdl1");

		    // go the next page
		    objLogin.clickNext_Password();
		   
		    //Verify Login title
	         Thread.sleep(3000);
		    String loginTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(objLogin.homePageTitleIsDisplayed());
	        Reporter.log("Home Page Header Title is : " + objLogin.getLoginTitle());
		    }
	 @AfterClass
	 public void CloseBrowser()
	 {
		 driver.quit();
	 }
	 
	 
	}

