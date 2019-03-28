package test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageFactory.GoogleLogin;
import PageFactory.HomePage;
import PageFactory.ApplicationSpec;
import PageFactory.LogOut;
import org.testng.Reporter;

public class TestExecution {
	WebDriver driver;

	GoogleLogin objLogin;
	HomePage objhome;
	ApplicationSpec objapp;
	LogOut objlogout;

	@BeforeTest

	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\MyDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://play.google.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public void testSignIn() throws InterruptedException {
		Thread.sleep(2000);
		objLogin = new GoogleLogin(driver);
		// Click on The Sign In Button
		objLogin.ClickOnSignIn();
		Reporter.log("Sign In");
	}

	@Test(priority = 2)

	public void testLoginUser() throws InterruptedException {

		// Write The User Name

		objLogin.loginWithUserName("hazimgoda683@gmail.com");

		// go the next page
		objLogin.clickNext_User();

		// Verify User title
		Thread.sleep(2000);
		String loginUserTitle = objLogin.getUserTitle();

		Assert.assertTrue(objLogin.userTitleIsDisplayed());
		// Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger
		// id : mgr123"));
		Reporter.log("User has been loged as : " + objLogin.getUserTitle());
	}

	@Test(priority = 3)
	public void testLoginPassword() throws InterruptedException {

		// Write The Password
		//Thread.sleep(2000);

		objLogin.loginWithPassword("Hgvplk@hgvpdl1");

		// go the next page
		objLogin.clickNext_Password();

		// Verify Login title
		Thread.sleep(3000);
		String loginTitle = objLogin.getLoginTitle();

		Assert.assertTrue(objLogin.homePageTitleIsDisplayed());
		Reporter.log("Home Page Header Title is : " + objLogin.getLoginTitle());
	}

	// Write Search Key word and click Search
	@Test(priority = 4)
	public void search() throws InterruptedException {

		objhome = new HomePage(driver);

		Thread.sleep(2000);
		// Write The Search text
		objhome.setSearch("elmenus");
		Thread.sleep(1000);
		// click on search button
		objhome.clickSearch();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// make Assertion to check if there are search results
		Assert.assertTrue(objhome.getNumberOfSearchElements() > 0);
		Reporter.log("Check if Number of search result is greater than 0 Number of Serch is  : "
				+ objhome.getNumberOfSearchElements());
	}

	// Click on the search result link of elmenus
	@Test(priority = 5)
	public void clickOnTheSearchResultLink() throws InterruptedException {

		objhome.clickOnSearchLink("elmenus");

		// Verify the Application Page
		Thread.sleep(1000);

//Assert if click the search text link and redirect to the Application specification 
		Assert.assertTrue(objhome.applicationPageTitleIsDisplayed());
		Reporter.log("Check if click the search text link and redirect to the Application specification : "
				+ objhome.applicationPageTitleIsDisplayed());
	}

	@Test(priority = 6)
	public void addOpenWishlist() throws InterruptedException {

		objapp = new ApplicationSpec(driver);
		boolean checkifappinstalled = objapp.checkisappinstalled();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (checkifappinstalled == false) {
			boolean checkisdisplayed = objapp.checkIsAddtoWishlinkisdisplayed();
			if (checkisdisplayed == true) {
				objapp.addtoWishlist();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(3000);
			objapp.openWishlist();
			// Assert if my wish list is displayed
			Assert.assertTrue(checkisdisplayed);
			Reporter.log("Check if my wish list is displayed : " + checkisdisplayed);
		} else
			Reporter.log("already installed");

	}

	// install elmenus application
	@Test(priority = 7)
	public void clickonWishListLink() throws InterruptedException {

		// clcik on elmenus at wish list
		boolean checkifappinstalled = objapp.checkisappinstalled();
		if (checkifappinstalled == false) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			objapp.clickOnwishlistlink("elmenus");
			Reporter.log("Select Elmenus Link from the wish List menu");
		}
	}

	@Test(priority = 8)
	public void clickoninstallButton() throws InterruptedException {
		boolean checkifappinstalled = objapp.checkisappinstalled();
		if (checkifappinstalled == false) {
			
			// scroll down
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(1000);
			// Click on install Button
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			objapp.installApp();
			Reporter.log("Click on the Install Button to install the Application");

		}
	}

	@Test(priority = 9)
	public void clickonPopupinstallButton() throws InterruptedException {
		boolean checkifappinstalled = objapp.checkisappinstalled();
		if (checkifappinstalled == false) {
			// click on the install button at the Popup Window
			Thread.sleep(1000);
			objapp.installappFromPopup();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Reporter.log("Elmenus Application has been Done !!!");
		}
	}
	@Test(priority = 10)
	public void clickOkButton() throws InterruptedException {
	if(objapp.clickOkAfterInstallation()==true)
		Reporter.log("Ok Button Clicked");
	else Reporter.log("Ok Button Not Clicked");
	}
	@Test(priority = 11)
	public void clickWriteaReview() throws InterruptedException {
		// click on the install button at the Popup Window
		// driver.navigate().back();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		objapp.writeReview();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
if(objapp.continueClick()==true)
			
			Reporter.log("Click on the Continue Button at the Popup and return back to the Application Page");
			
			else
			
				Reporter.log("Continue Button Already Clicked before");
		
		
		Reporter.log("Popup window should be displayed successfully for writing review");
	}


	@Test(priority = 12)
	public void writeaReviewText() throws Exception {

		
		Thread.sleep(2000);
		// objapp.WriteReviewText("Test");

		objapp.addReview();

		// Take a print Screen and save it
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objapp.takeSnapShot(driver, ".//ScreenShoot//test.png");
		// driver.navigate().back();

		Reporter.log("Fifth star has been selected and written Test");
	}

	@Test(priority = 13)
	public void deleteWritenReview() throws InterruptedException {
	
		Thread.sleep(1000);
		// scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(800,0)", "");
		Thread.sleep(1000);
		// Delete The Review
		objapp.deleteReview();
		Thread.sleep(1000);
		Reporter.log("Review has been deleted");

	}

	// Log Out
	@Test(priority = 14)
	public void logOut() throws InterruptedException {
		objlogout = new LogOut(driver);
		// expand the Google Account Menu
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(2000,-1000)", "");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objlogout.expandGoogleAccountMenu();
		Thread.sleep(1000);
		// Click Log out

		objlogout.LogOut();
		assertTrue(objlogout.checkIsLogOut());
		Reporter.log("Log Out From The Google Play");

	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
