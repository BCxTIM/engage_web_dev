package applogic1;

import applogic.ApplicationManager;
import applogic.MailsHelper;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class MailsHelper1 extends DriverBasedHelper implements MailsHelper {

    private ApplicationManager manager;

    public MailsHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.manager = manager;
    }


    @Override
    public void openLastEmail(String text) {
        pages.mailsPage.openLastEmail();
    }

    @Override
    public boolean verifySubject(String text) {
        pages.mailsPage.ensureMailIsOpened();
        return pages.mailsPage.subject.getText().contains(text);
    }


    @Override
    public boolean verifyDescription(String text) {
        return driver.getPageSource().contains(text);
    }
}
