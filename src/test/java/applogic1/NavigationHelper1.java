package applogic1;

import applogic.NavigationHelper;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class NavigationHelper1 extends DriverBasedHelper implements NavigationHelper {


    private String baseUrl;

    public NavigationHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    @Override
    public void openMainPage() {
        driver.get(baseUrl);
    }
}
