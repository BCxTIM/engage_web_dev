package applogic1;

import applogic.*;
import engage.util.Browser;
import engage.util.PropertyLoader;
import engage.webdriver.WebDriverFactory;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ApplicationManager1 implements ApplicationManager {

    private NavigationHelper navHelper;
    private LoginHelper loginHelper;
    private ComposeHelper composeHelper;
    private MailsHelper mailsHelper;

    private WebDriver driver;
    protected String gridHubUrl;

    private String baseUrl;

    protected Browser browser;

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";


    public ApplicationManager1()  {

        //PropertyConfigurator.configure("Log4j.properties");
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
        composeHelper = new ComposeHelper1(this);
        mailsHelper = new MailsHelper1(this);



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
    public ComposeHelper getComposeHelper() {
        return composeHelper;
    }

    @Override
    public MailsHelper getMailsHelper() {
        return mailsHelper;
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
