package tests;

import engage.pages.TestBase;
import model.LoginModel;
import org.testng.annotations.Test;


/**
 * Created by timrusso on 4/25/16.
 */
public class LoginTests extends TestBase {


    @Test
    public void testOne() throws Exception {
        LoginModel loginModel = new LoginModel().setPhone("123456789");
        app.getLoginHelper().loginAs(loginModel);
    }

}
