package engage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by timrusso on 4/28/16.
 */
public class PageManager {

    private WebDriver driver;

    public LoginPage loginPage;

    public InternalPage internalPage;



    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
        internalPage = initElements(new InternalPage(this));

    }

    private < T extends Page>  T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
