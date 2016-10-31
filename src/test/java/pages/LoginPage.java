package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class LoginPage extends AnyPage {

   public LoginPage(PageManager pages) {
       super(pages);
   }


    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(id = "Passwd")
    public WebElement passwordField;

    @FindBy(id = "signIn")
    public WebElement signInButton;


    public LoginPage setEmail(String phone) {
        emailField.sendKeys(phone);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickNextButton() {
        nextButton.click();
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }









}
