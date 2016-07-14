package applogic1;


import applogic.LoginHelper;
import model.LoginModel;


/**
 * Created by timrusso on 4/28/16.
 */
public class LoginHelper1 extends DriverBasedHelper implements LoginHelper {

    private ApplicationManager1 manager;

    public LoginHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.manager = manager;
    }

    public void loginAs(LoginModel loginModel) {
        pages.loginPage.setPhone(loginModel.getPhone());
    }

}
