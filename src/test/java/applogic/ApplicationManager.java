package applogic;

import org.openqa.selenium.WebDriver;

/**
 * Created by timrusso on 4/28/16.
 */
public interface ApplicationManager {

    LoginHelper getLoginHelper();


    void stop();
    WebDriver getWebDrivier();

}
