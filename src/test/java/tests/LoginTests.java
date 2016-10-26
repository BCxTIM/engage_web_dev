package tests;

import engage.pages.TestBase;
import model.LoginModel;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by timrusso on 4/25/16.
 */
public class LoginTests extends TestBase {




    @Test
    public void loginOK() throws Exception {
        LoginModel loginModel = new LoginModel().setEmail("verront@gmail.com");
        app.getLoginHelper().loginAs(loginModel);
        assertTrue(app.getLoginHelper().ifPasswordFormOpened());
    }


}
