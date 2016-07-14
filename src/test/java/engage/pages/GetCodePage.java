package engage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by timrusso on 7/14/16.
 */
public class GetCodePage extends AnyPage {

    public GetCodePage(PageManager pages) {
        super(pages);
    }


    @FindBy(name = "password")
    public WebElement passwordField;



}
