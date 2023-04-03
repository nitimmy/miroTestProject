/**
 * 
 */
package miro_pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miro_imran_assign.BaseTest;

/**
 * @author imranBaig
 *
 */
public class LoginPage extends BaseTest {
	
	//Page Factory - OR:
	
		@FindBy(xpath = "//input[@id='a11y-signup-with-google']")
		WebElement signInWithGoogleLink;
		@FindBy(xpath = "//input[@id='email']")
		WebElement workEmail;
		@FindBy(xpath = "//input[@id='password']")
		WebElement password;
		@FindBy(xpath = "//button[@class='signup__submit']")
		WebElement signInBtn;
		@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
		WebElement acceptCookies;
		
		
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		public HomePage login(String email, String pwd){
			//signInWithGoogleLink.click();
			workEmail.sendKeys(email);			
			password.sendKeys(pwd);
			acceptCookies.click();
			signInBtn.click();
			    	
			return new HomePage();
		}
		
		

}
