package engage.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by timrusso on 4/26/16.
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


    public LoginPage setEmail(String phone) {
        emailField.sendKeys(phone);
        return this;
    }

    public void clickNextButton() {
        nextButton.click();
    }









}
