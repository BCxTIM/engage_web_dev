package applogic;

import model.LoginModel;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public interface LoginHelper {

    void loginAs(LoginModel loginModel);
    boolean ifUserLogin();

}
