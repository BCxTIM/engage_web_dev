package applogic;


/**
 * Created by timrusso on 4/28/16.
 */
public interface ApplicationManager {

    NavigationHelper getNavigationHelper();
    LoginHelper getLoginHelper();
    GetCodeHelper getCodeHelper();
    void stop();

}
