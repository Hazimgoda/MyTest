package Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
public class GoogleLogin {
	WebDriver driver;

    By GoogleUserName = By.xpath("//*[@id=\"identifierId\"]");

    By GoogleUserPassword = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input");

    By titleUserText =By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div/h1/content");

    By UserNextButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content");
    By PasswordNextButton=By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span");
    By titleLoginText =By.xpath("/html/body/c-wiz/div/div[2]/c-wiz/c-wiz/div/div[4]/div/div/header/h1");

    public GoogleLogin(WebDriver driver){

        this.driver = driver;
    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(GoogleUserName).sendKeys(strUserName);

    }
   //Click Next Button after filling User Name
    public void clickNext_User(){

        driver.findElement(UserNextButton).click();

}
    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(GoogleUserPassword).sendKeys(strPassword);

    }
    //Click Next Button after filling Password
    public void clickNext_Password(){

        driver.findElement(PasswordNextButton).click();

}
    //Get the title of Login Page

    public String getUserTitle(){

     return driver.findElement(titleUserText).getText();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

     return    driver.findElement(titleLoginText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void LoginWithUserName(String strUserName){

        //Fill user name

        this.setUserName(strUserName);

              //Click Next button after filling User Name

        this.clickNext_User();        
    }
    public void LoginWithPassword(String strPassword){

        //Fill Password

        this.setPassword(strPassword);

              //Click Next button after filling Password

        this.clickNext_Password();        
    }
}


