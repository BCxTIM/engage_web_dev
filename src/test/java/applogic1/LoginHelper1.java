package applogic1;


import applogic.LoginHelper;
import model.LoginModel;


/**
 * Created by tmoiseev on 10/31/2016.
 */
public class LoginHelper1 extends DriverBasedHelper implements LoginHelper {

    private ApplicationManager1 manager;

    public LoginHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.manager = manager;
    }

    public void loginAs(LoginModel loginModel) {
        pages.loginPage
                .setEmail(loginModel.getEmail())
                .clickNextButton()
                .setPassword(loginModel.getPassword())
                .clickSignInButton();
    }

    @Override
    public boolean ifUserLogin() {
        return pages.mailsPage.ensurePageLoaded()
                .composeButton.isDisplayed();
    }


}
