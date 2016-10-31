package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class PageManager {

    private WebDriver driver;

    public InternalPage internalPage;
    public LoginPage loginPage;
    public MailsPage mailsPage;
    public ComposePage composePage;




    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
        internalPage = initElements(new InternalPage(this));
        mailsPage = initElements(new MailsPage(this));
        composePage = initElements(new ComposePage(this));

    }

    private < T extends Page>  T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
