/**
 * 
 */
package miro_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miro_imran_assign.BaseTest;
import miro_imran_assign.UtilityClass;



/**
 * @author imranBaig
 *
 */
public class HomePage extends BaseTest {
	
	@FindBy(xpath = "//div[@class='serviceCard__tile-ipSll']")
	WebElement  	NewBoard;
	@FindBy(xpath = "//div[@class='buttons-1uk5i']/button")
	WebElement  	createNewBoard;
	@FindBy(xpath = "//div[@class='tpicker__sidebar']")
	WebElement  	templatePickerPopUp;
	@FindBy(xpath = "//button[@class='tpicker__close-btn closeButton-3YOjP']")
	WebElement  	templatePickerclose;
	@FindBy(xpath = "//div[@class='title__container-21Vfi']")
	WebElement  	boardNameTitle;
	@FindBy(xpath = "//input[@class='boardInfoTitle-BwLVb input-2wg2F']")
	WebElement  	boardName;
	@FindBy(xpath = "//canvas[@id='active_users_layer']")
	WebElement  	canvasScreen;
	@FindBy(xpath = "//div[@class='creationBarSortable-y5Q2X']//div/button[@data-testid='CreationBarButton--STICKERS']")
	WebElement  	stickerIcon;
	@FindBy(xpath = "//div[@class='buttonsContainer-M2ht9']//button")
	WebElement  	shareBoard;
	@FindBy(xpath = "//input[@data-testid='inviteByEmailInputPlaceholderInput']")
	WebElement  	emailID;
	@FindBy(xpath = "//button[@data-testid='shareMdButtonSend']")
	WebElement  	sendInvitation;
	@FindBy(xpath = "//button[@data-testid='set-start-view__doneBtnText']")
	WebElement  	doneBtn;
	
	@FindBy(xpath = "//button[@data-testid='dashboard__scroller-view-toggle__list-button']")
	WebElement  clickOnListView;
	
	@FindBy(xpath = "//div[@class='row-7wK4e item-ipIWQ board-item btn']/div//div[@class='titleText-3hP0m']")
	WebElement  boardNameLists;

	
	
	
	
	
	
	
	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		
public HomePage createBoard(String bName) throws InterruptedException{
			
	
UtilityClass.waitUntillElementLoaded(NewBoard);
 NewBoard.click();
 UtilityClass.waitUntillElementLoaded(createNewBoard);
  createNewBoard.click();
  UtilityClass.waitUntillElementLoaded(templatePickerclose);
	templatePickerclose.click();
	UtilityClass.waitUntillElementLoaded(boardNameTitle);
	boardNameTitle.click();
	UtilityClass.waitUntillElementLoaded(boardName);
	boardName.clear();
	boardName.sendKeys(bName);
	UtilityClass.waitUntillElementLoaded(canvasScreen);
	new Actions(driver)
	.moveToElement(canvasScreen, 450, 50).click().perform();
	UtilityClass.waitUntillElementLoaded(stickerIcon);
	stickerIcon.click();
	UtilityClass.waitUntillElementLoaded(stickerIcon);	
	new Actions(driver)
	.moveToElement(stickerIcon, 48, 61).click().perform();
	
	new Actions(driver)
	.moveToElement(stickerIcon, 63, 58).click().perform();
	
	UtilityClass.waitUntillElementLoaded(canvasScreen);
	new Actions(driver)
	.moveToElement(canvasScreen, 75, 65).click().perform();

	
	new Actions(driver)
	.moveToElement(canvasScreen, 75, 65).sendKeys("This is Board Name"+" " +bName +"sticker").perform();
	
	
	new Actions(driver)
	.moveToElement(canvasScreen, 450, 50).click().perform();
	UtilityClass.waitUntillElementLoaded(shareBoard);
	
	shareBoard.click();
	UtilityClass.waitUntillElementLoaded(emailID);
	emailID.sendKeys(prop.getProperty("username2"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.querySelector(\"button[data-testid=shareMdButtonSend]\").click()");
	UtilityClass.waitUntillElementLoaded(sendInvitation);
	
	sendInvitation.click();
	UtilityClass.waitUntillElementLoaded(doneBtn);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("document.querySelector(\"button[data-testid=set-start-view__doneBtnText]\").click()");
	//doneBtn.click();
	
	
	return new HomePage();
		}



public HomePage verifyBoard(String bName) throws InterruptedException{
	
	UtilityClass.waitUntillElementLoaded(clickOnListView);
	clickOnListView.click();
	UtilityClass.waitUntillElementLoaded(boardNameLists);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("arguments[0].scrollIntoView(true);", boardNameLists);
	List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='row-7wK4e item-ipIWQ board-item btn']/div//div[@class='titleText-3hP0m']"));
	for (WebElement option : allOptions) {
	    System.out.println(String.format("Value is: %s", option.getText()));
	    //
	   // Object vaLue = "Gram";
	    if (option.getText().equals(bName)) {
	        System.out.println("Pass");
	       
	        UtilityClass.waitUntillElementLoaded(option);
	        //Actions actions = new Actions(driver);
	       // actions.moveToElement(option).click().perform();
	        jse.executeScript("arguments[0].click();", option);
	        UtilityClass.waitUntillElementLoaded(canvasScreen); 
	       // Thread.sleep(5000);
	        break;
	    } else {
	        System.out.println(option.getText());
	    }
	}
	
	
	
	return new HomePage();
}


}
