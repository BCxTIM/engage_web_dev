package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class MailsPage extends AnyPage {

    public MailsPage(PageManager pages) {
        super(pages);
    }

    public MailsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("z0")));
        return this;
    }

    public MailsPage ensureMailIsOpened() {
        super.ensurePageLoaded();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2[class='hP']")));
        return this;


    }

    @FindBy(className = "z0")
    public WebElement composeButton;

    @FindBy(xpath = "//*[@id='link_vsm']")
    public WebElement viewMessageLink;

    @FindBy(css = "")
    public WebElement emailFrom;

    @FindBy(css = "h2[class='hP']")
    public WebElement subject;

    @FindBy(css = "h2[class='hP']")
    public WebElement description;



    public MailsPage ensureMailWasSent() {
        super.ensurePageLoaded();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='link_vsm']")));
        return this;
    }

    public void openLastEmail() {
        viewMessageLink.click();
    }

    public void openComposeEmailForm() {
        composeButton.click();
    }


}
