package applogic1;

import applogic.ApplicationManager;
import applogic.GetCodeHelper;

/**
 * Created by timrusso on 7/14/16.
 */
public class GetCodeHelper1 extends DriverBasedHelper implements GetCodeHelper {

    private ApplicationManager manager;

    public GetCodeHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.manager = manager;
    }


    @Override
    public boolean isGetCodePageOpen() {
        return pages.getCodePage.passwordField.isDisplayed();
    }
}
