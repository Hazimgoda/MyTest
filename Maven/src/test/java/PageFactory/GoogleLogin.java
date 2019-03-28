package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLogin {
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	@FindBy(id="gb_70")
	WebElement SignInButton;
	
	
	@FindBy(id="identifierId")
	WebElement GoogleUserName;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
	WebElement GoogleUserPassword;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div/h1/content")
	WebElement titleUserText;
	
	@FindBy(id="passwordNext")
	WebElement PasswordNextButton;

	@FindBy(xpath="//*[@id=\"identifierNext\"]")
	WebElement UserNextButton;
	
	    
	@FindBy(xpath="//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/div/c-wiz/c-wiz[1]/c-wiz/div/div[1]/div[1]/a/h2")
	WebElement titleLoginText;
	
	public GoogleLogin(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	//Click on the Sign In Button
	 public void ClickOnSignIn()
	 {
	
		Actions actions = new Actions(driver);
	   	actions.moveToElement(SignInButton).click().build().perform();
	        
	}
	  public void setUserName(String strUserName){

	        GoogleUserName.sendKeys(strUserName);

	    }
	   //Click Next Button after filling User Name
	    public void clickNext_User(){
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(UserNextButton).click().build().perform();
	    	

	}
	    //Set password in password textbox

	    public void setPassword(String strPassword){

	         GoogleUserPassword.sendKeys(strPassword);

	    }
	    //Click Next Button after filling Password
	    public void clickNext_Password(){
	    
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(PasswordNextButton).click().build().perform();
	    
	}
	    //Get the title of Login Page

	    public String getUserTitle(){

	     return titleUserText.getText();

	    }
           //check is user title is displayed
	    public boolean userTitleIsDisplayed(){

		     return titleUserText.isDisplayed();

		    }
	      //check Home Page title is displayed
		    public boolean homePageTitleIsDisplayed(){

			     return titleLoginText.isDisplayed();

			    }
	    //Get the title of Login Page

	    public String getLoginTitle(){

	     return titleLoginText.getText();

	    }

	    /**

	     * This POM method will be exposed in test case to login in the application

	     * @param strUserName

	     * @param strPasword

	     * @return

	     */

	    public void loginWithUserName(String strUserName){

	        //Fill user name

	        this.setUserName(strUserName);

	              //Click Next button after filling User Name

	        this.clickNext_User();        
	    }
	    public void loginWithPassword(String strPassword){

	        //Fill Password

	        this.setPassword(strPassword);

	              //Click Next button after filling Password

	        this.clickNext_Password();        
	    }

	}
