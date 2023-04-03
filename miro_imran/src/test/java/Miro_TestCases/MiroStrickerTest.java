/**
 * 
 */
package Miro_TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import miro_imran_assign.BaseTest;
import miro_imran_assign.UtilityClass;
import miro_pages.HomePage;
import miro_pages.LoginPage;


/**
 * @author imranBaig
 *
 */
public class MiroStrickerTest  extends BaseTest{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public MiroStrickerTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		
	}
	
	@Test
	public void createBoardTest() throws InterruptedException, IOException{
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		homePage.createBoard(prop.getProperty("BoardName"));
		UtilityClass.takeScreenshotAtEndOfTest();
	}
	
	
	
	
	@Test(dependsOnMethods = "createBoardTest")
	public void secondUserVerifyBoardTest() throws InterruptedException, IOException{
		homePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
		homePage.verifyBoard(prop.getProperty("BoardName"));
		UtilityClass.takeScreenshotAtEndOfTest();
	}

	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

