package applogic1;

import applogic.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by timrusso on 4/28/16.
 */
public class ApplicationManager1 implements ApplicationManager {

    private LoginHelper loginHelper;


    private WebDriver driver;

    public ApplicationManager1() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "Appium");

        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("deviceName", "Nexus_5X_API_22");

        File file = new File("/Users/timrusso/.jenkins/workspace/testgradle/app/build/outputs/apk/app-advisor-debug.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new WebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
        };
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        loginHelper = new LoginHelper1(this);


    }



    public LoginHelper getLoginHelper() {
        return  loginHelper;
    }



    public void stop() {
        if(driver != null) {
            driver.quit();
        }
    }

    public WebDriver getAndroidDriver() {
        return driver;
    }



}
