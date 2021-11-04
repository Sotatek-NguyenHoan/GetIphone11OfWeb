package test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	private WebDriver driver;
	public String urleBay="https://www.ebay.com/";
	public String urleLazada="https://www.lazada.vn/";
	public void clickToButton(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void sendKeyWordToTextBox( WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	public void clear(WebElement element) {
		element.clear();
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getWeb(String url){
		driver.get(url);
	}

}
