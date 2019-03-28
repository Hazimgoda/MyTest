package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	
	WebDriver driver;
	//Google Account Icon
	@FindBy(xpath="/html/body/div[1]/c-wiz[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[1]")
		WebElement googleAccountButton;
	
	
	//Log Out Button
		@FindBy(xpath="//*[@id=\"gb_71\"]")
		WebElement logOutButton;
		//Check Logout Div
		
		@FindBy(xpath="//*[@id=\"profileIdentifier\"]")
		WebElement checkLogOut;
		
	//intialize Page Factory
		public LogOut(WebDriver driver){
			this.driver = driver;
			//This initElements method will create  all WebElements
			PageFactory.initElements(driver, this);
		}
	
		 //Click on The Google Account Icon
	    public void expandGoogleAccountMenu(){
	    
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(googleAccountButton).click().build().perform();
	    
	}
	  //Click on Log Out Link
	    public void LogOut(){
	    
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(logOutButton).click().build().perform();
	    
	}
	    //check Logout 
	    public boolean checkIsLogOut(){

	 	    
	 	     try
	 		    {
	 		        if(checkLogOut.isDisplayed())
	 		        {
	 		           //doing Nothing.
	 		        }
	 		        return true;
	 		    }
	 		    catch (Exception e)
	 		    {
	 		    	
	 		        return false;
	 		    }
	 	    }
}
