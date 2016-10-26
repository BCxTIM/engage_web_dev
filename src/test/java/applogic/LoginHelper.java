package applogic;

import model.LoginModel;

/**
 * Created by timrusso on 4/28/16.
 */
public interface LoginHelper {

    void loginAs(LoginModel loginModel);
    boolean ifPasswordFormOpened();

}
