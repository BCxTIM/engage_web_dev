package applogic;


/**
 * Created by tmoiseev on 10/31/2016.
 */
public interface ApplicationManager {

    NavigationHelper getNavigationHelper();
    LoginHelper getLoginHelper();
    ComposeHelper getComposeHelper();
    MailsHelper getMailsHelper();

    void stop();

}
