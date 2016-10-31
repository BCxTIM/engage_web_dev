package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ComposePage extends AnyPage {
    public ComposePage(PageManager pages) {
        super(pages);
    }

    public ComposePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(":bw")));
        return this;
    }



    @FindBy(name = "to")
    public WebElement toEmailField;

    @FindBy(name = "subjectbox")
    public WebElement subjectField;

    @FindBy(css = "div[class='Am Al editable LW-avf']")
    public WebElement descriptionField;

    @FindBy(css = "div[class='T-I J-J5-Ji aoO T-I-atl L3']")
    public WebElement sendButton;

    @FindBy(css = "div[class='Kj-JD-Jz']")
    public WebElement emailNotSentText;

    @FindBy(css ="button[class='J-at1-auR']")
    public WebElement okButton;

    public ComposePage setToEmail(String email) {
        toEmailField.sendKeys(email);
        return this;
    }

    public ComposePage setSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }

    public ComposePage setDescription(String description) {
        descriptionField.sendKeys(description);
        return this;
    }

    public void sendClick() {
        sendButton.click();
    }

    public void closePopup() {
        okButton.click();
    }
}
