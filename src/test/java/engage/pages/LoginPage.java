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


    @FindBy(name = "mobile")
    public WebElement phoneField;

    @FindBy(css = ".btn.btn-primary.btn-lg")
    public WebElement getCodeButton;


    public LoginPage setPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    public void clickGetCodeButton() {
        getCodeButton.click();
    }









}
