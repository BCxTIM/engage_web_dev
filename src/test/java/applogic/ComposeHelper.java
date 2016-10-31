package applogic;

import model.ComposeModel;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public interface ComposeHelper {

    void composeEmail(ComposeModel composeModel);
    boolean ifEmailSent();
    boolean ifEmailNotSent();
    void closePopUp();

}
