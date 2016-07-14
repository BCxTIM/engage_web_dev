package applogic1;

import applogic.*;
import engage.util.Browser;
import engage.util.PropertyLoader;
import engage.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by timrusso on 4/28/16.
 */
public class ApplicationManager1 implements ApplicationManager {

    private NavigationHelper navHelper;
    private LoginHelper loginHelper;
    private GetCodeHelper getCodeHelper;

    private WebDriver driver;
    protected String gridHubUrl;

    private String baseUrl;

    protected Browser browser;

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";


    public ApplicationManager1()  {

        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

        browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.username");
        String password = PropertyLoader.loadProperty("user.password");

        driver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
                password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginHelper = new LoginHelper1(this);
        navHelper = new NavigationHelper1(this);
        getCodeHelper = new GetCodeHelper1(this);


        getNavigationHelper().openMainPage();

    }

    @Override
    public NavigationHelper getNavigationHelper() {
        return navHelper;
    }

    @Override
    public LoginHelper getLoginHelper() {
        return  loginHelper;
    }

    @Override
    public GetCodeHelper getCodeHelper() {
        return getCodeHelper;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }


    @Override
    public void stop() {
        if(driver != null) {
            driver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }


    //	@AfterMethod
//	public void setScreenshot(ITestResult result) {
//		if (!result.isSuccess()) {
//			try {
//				WebDriver returned = new Augmenter().augment(driver);
//				if (returned != null) {
//					File f = ((TakesScreenshot) returned)
//							.getScreenshotAs(OutputType.FILE);
//					try {
//						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
//								+ result.getName() + SCREENSHOT_FORMAT));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (ScreenshotException se) {
//				se.printStackTrace();
//			}
//		}
//	}



}
