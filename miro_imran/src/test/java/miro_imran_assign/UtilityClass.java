/**
 * 
 */
package miro_imran_assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;



/**
 * @author imranBaig
 *
 */
public class UtilityClass extends BaseTest {
	

	public static long explicitTimeOut = 60;

	
	
	/**
	 * This function is used to take screenshot at any point of application running
	 * @throws IOException
	 */
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		long abc=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(abc); 
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +date+System.currentTimeMillis() + ".png"));
	}
	


	/**
	*  This function waitUntillElementLoaded to be present
	*  @param element
	*/
	public static void waitUntillElementLoaded(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTimeOut));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}


}
	
