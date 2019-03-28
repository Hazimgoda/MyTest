package PageFactory;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationSpec {

	WebDriver driver;
	// Search TextBox
	@FindBy(xpath = "//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/c-wiz/wishlist-add/button/span[2]")
	WebElement AddtoWishListLink;

	@FindBy(xpath = "//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/div[2]/ul/li[5]/a/span[2]")
	WebElement MyWishList;

	@FindBy(xpath = "//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/c-wiz/c-wiz/c-wiz/div/div[1]/div/h2")
	WebElement MyWishListHeadertext;

	// List of all links at wishlist
	@FindBy(xpath="(//div[contains(text(), 'elmenus')])[1]")
	  
	WebElement linksatwishlist;

	// Install Button
	@FindBy(xpath = "//*[text()='Install']")
	WebElement InstallationButton;

	// Installed Button
	@FindBy(xpath = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/c-wiz/c-wiz/button")
	WebElement installedcheck;

	// Devices combo Box
	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")
	WebElement DevicesComboBox;

	// Device Selection
	@FindBy(className = "device-selector-dropdown-child")
	List<WebElement> AllDevices;

	// popup install Button

	@FindBy(id = "purchase-ok-button")
	WebElement popupinstallbutton;

	// Continue Popup
	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div[1]/div/div/div[2]/div[1]/div[3]/div/button")
	WebElement continueButton;

	// Write a review
	@FindBy(xpath = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[1]/span/button")
	WebElement writeReviewButton;

	// List of stars
	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div[4]/div/div/div[1]/div[3]//button")

	List<WebElement> ListofStars;

	// Write a review
	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div[2]/div/textarea")
	WebElement writeReviewTextarea;

	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div[2]/div/textarea")
	private List<WebElement> writeReviewTextList;

	// submit button

	@FindBy(xpath = "/html/body/div[9]/div[1]/div/div/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div[5]/div[1]/button")
	WebElement submitButton;
	// Delete Button
	@FindBy(xpath = "//div[@data-tooltip='Delete review']//span/*")
	WebElement deleteButton;

	//check Iframe
	@FindBy(xpath = "//div[contains(text(), 'Reviews are public and editable')]")
	WebElement checkiframe;
	
	//Ok Button
		@FindBy(xpath = "//*[@id=\"close-dialog-button\"]")
		WebElement okButton;
		
	
	boolean iFrameCheck=false;
	// intialize Page Factory
	public ApplicationSpec(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Add Applcation to the Wishlist
	public void addtoWishlist() {

		Actions actions = new Actions(driver);
		actions.moveToElement(AddtoWishListLink).click().build().perform();
	}

	// Open the Wishlist
	public void openWishlist() {

		Actions actions = new Actions(driver);
		actions.moveToElement(MyWishList).click().build().perform();

	}

	// check if wishlist link is displayed
	public boolean checkIsAddtoWishlinkisdisplayed() {

		try {
			if (AddtoWishListLink.isDisplayed()) {
				// doing Nothing.
			}
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	// check if header is displayed
	public boolean myWishlistPageTitleIsDisplayed() {
		try {
			if (MyWishListHeadertext.isDisplayed()) {
				// doing Nothing.
			}
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	//check iframe
		public boolean checkiframisdisplayed() {
			try {
				Thread.sleep(2000);
				new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id,'I')]")));
				Thread.sleep(2000);

				if (checkiframe.isDisplayed()) {
					// doing something.
					iFrameCheck=true;
					System.out.println("All is Good");
					
				}
				return iFrameCheck;
			} catch (Exception e) {
      System.out.println("HazCh "+e.getMessage());
			iFrameCheck=false;
			System.out.println("chekHaz It is false"+iFrameCheck);
			return false;
				
			}
		}

	// Install The Application
	public void installApp() {

		Actions actions = new Actions(driver);
		actions.moveToElement(InstallationButton).click().build().perform();
	}

	
	// Click on specific link at wish list
	public void clickOnwishlistlink(String strSearch) {

		linksatwishlist.click();
	}

	// Install The Application
	public void installappFromPopup() throws InterruptedException {
     
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id,'I')]")));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(popupinstallbutton).click().build().perform();

	}

	// Write a review
	public void writeReview() {

		Actions actions = new Actions(driver);
		actions.moveToElement(writeReviewButton).click().build().perform();

	}

	// check if installed
	public boolean checkisappinstalled() {
		try {
			if (installedcheck.isDisplayed()) {
				// doing Nothing.
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//Continue Popup
	public boolean continueClick() throws InterruptedException {
		try {
			
			
if (checkiframisdisplayed()==true)
{
	//new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id,'I')]")));
	Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.moveToElement(continueButton).click().build().perform();
	
			return true;
}
return false;
} catch (WebDriverException e) {
			System.out.println("HazExc : "+e.getMessage());
			return false;
		}
	}

	// Select Fifth Star
	public void addReview() throws InterruptedException {
		//List<WebElement> TotaliFrames = driver.findElements(By.tagName("iframe"));
		//System.out.println("TotaliFrames\t" + TotaliFrames.size());
		
		if(iFrameCheck==true)
		{
			Thread.sleep(5000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id,'I')]")));
		}
		Actions actions = new Actions(driver);
		//actions.moveToElement(ListofStars.get(4)).click().build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ListofStars.get(4));

		Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[contains(@class,'review-input')]")).click();
			driver.findElement(By.xpath("//textarea[contains(@class,'review-input')]")).sendKeys("test");

		   
		// Submit button - Create Review
		actions.moveToElement(submitButton).click().build().perform();

		
	}

	// Take Print Screen
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	// Delete Review
	public void deleteReview() {

		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", deleteButton);

	//	actions.moveToElement(deleteButton).click().build().perform();

	}
	// Install The Application
		public boolean clickOkAfterInstallation() throws InterruptedException {
	     try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id,'I')]")));
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			
			actions.moveToElement(okButton).click().build().perform();
			return true;
	     }
	     catch(Exception e)
	     {
	    	 System.out.println("Ok Button :"+e.getMessage());
	    	 return false;
	     }
		}
}
