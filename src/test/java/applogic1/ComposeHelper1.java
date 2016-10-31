package applogic1;

import applogic.ApplicationManager;
import applogic.ComposeHelper;
import model.ComposeModel;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ComposeHelper1 extends DriverBasedHelper implements ComposeHelper {

    private ApplicationManager manager;

    public ComposeHelper1(ApplicationManager1 manager) {
        super(manager.getWebDriver());
        this.manager = manager;
    }

    @Override
    public void composeEmail(ComposeModel composeModel) {
        pages.mailsPage.openComposeEmailForm();
        pages.composePage
                .setToEmail(composeModel.getToEmail())
                .setSubject(composeModel.getSubject())
                .setDescription(composeModel.getDescription())
                .sendClick();
    }

    @Override
    public boolean ifEmailSent() {
        pages.mailsPage.ensureMailWasSent();
        return pages.mailsPage.viewMessageLink.getText().contains("View message");
    }

    @Override
    public boolean ifEmailNotSent() {
        return pages.composePage.emailNotSentText.getText().contains("Please specify at least one recipient.");
    }

    @Override
    public void closePopUp() {
        pages.composePage.closePopup();
    }
}
