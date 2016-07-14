package engage.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page {

	protected WebDriver webDriver;
	protected  PageManager pages;
	protected WebDriverWait wait;


	public Page ensurePageLoaded() {
		return this;
	}

	public boolean waitPageLoaded() {
		try {
			ensurePageLoaded();
			return true;
		} catch (TimeoutException to) {
			return  false;
		}
	}

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

}
