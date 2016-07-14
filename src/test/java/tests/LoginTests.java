package tests;

import engage.pages.TestBase;
import model.LoginModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by timrusso on 4/25/16.
 */
public class LoginTests extends TestBase {


    @BeforeMethod
    public void openMainPage() throws Exception {
        app.getNavigationHelper().openMainPage();
    }

    @Test
    public void loginOK() throws Exception {
        LoginModel loginModel = new LoginModel().setPhone("123456789");
        app.getLoginHelper().loginAs(loginModel);
        assertTrue(app.getCodeHelper().isGetCodePageOpen());
    }

    @Test
    public void loginNOK() throws Exception {
        LoginModel loginModel = new LoginModel().setPhone("12345");
        app.getLoginHelper().loginAs(loginModel);
        assertTrue(app.getCodeHelper().isGetCodePageOpen());
    }

}
