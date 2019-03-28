package PageFactory;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
          
	WebDriver driver;
	//Search TextBox
	@FindBy(name="q")
	WebElement SearchTextBox;
	
	//Search Button
	@FindBy(xpath="//*[@id=\"gbqfb\"]")
	              
	WebElement SearchButton;
	
	@FindBy(xpath="//*[@id=\"body-content\"]/div[1]/div/div[1]/div/div/div/div[2]//div")
	List <WebElement> Apps;
	
	//links titles
	@FindBy(xpath="//div[contains(@class,'id-card-list')]/div//a[contains(.,'elmenus')][1]")
  
	WebElement searchTitles;
	
	
	@FindBy(xpath="//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[1]/c-wiz[1]/h1/span")
	WebElement ApplicationHeaderText;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	//Set Search Key word at the Search textbox

    public void setSearch(String strSearch){

    	SearchTextBox.sendKeys(strSearch);

    }
  //Click Search Button 
    public void clickSearch(){
    
    	Actions actions = new Actions(driver);
    	actions.moveToElement(SearchButton).click().build().perform();
    
}
    //get number of total search result elements
    public int getNumberOfSearchElements(){

    	return Apps.size();

	    }
  //Click on specific search result link
    public void clickOnSearchLink(String strSearch){

    	
    	searchTitles.click();
	    }
    //check Application Page title is displayed
    public boolean applicationPageTitleIsDisplayed(){

	     return ApplicationHeaderText.isDisplayed();

	    }
}
