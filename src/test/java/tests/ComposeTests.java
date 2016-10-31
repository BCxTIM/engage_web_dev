package tests;

import model.ComposeModel;
import model.LoginModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TestBase;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ComposeTests extends TestBase {

    private String email = "timofei.moiseev88@gmail.com";
    private String password = "nWrjvyRevT1";
    private String subject = "Test";
    private String description = "Test description";

    @BeforeClass
    public void loginAsUser() throws Exception {
        LoginModel loginModel = new LoginModel()
                .setEmail(email)
                .setPassword(password);
        app.getLoginHelper().loginAs(loginModel);
        assertTrue(app.getLoginHelper().ifUserLogin());

    }

    @Test
    public void composeEmailOk() throws Exception {
        ComposeModel composeModel = new ComposeModel()
                .setToEmail(email)
                .setSubjecField(subject)
                .setDescription(description);
        app.getComposeHelper().composeEmail(composeModel);
        assertTrue(app.getComposeHelper().ifEmailSent());
    }

    @Test(dependsOnMethods = "composeEmailOk")
    public void verifySentEmail() throws Exception {
        app.getMailsHelper().openLastEmail(subject);
        assertTrue(app.getMailsHelper().verifySubject(subject));
        assertTrue(app.getMailsHelper().verifyDescription(description));
    }

    @Test(dependsOnMethods = "verifySentEmail")
    public void composeEmailWithEmptyFields() throws Exception {
        ComposeModel composeModel = new ComposeModel()
                .setToEmail("")
                .setSubjecField("")
                .setDescription("");
        app.getComposeHelper().composeEmail(composeModel);
        assertTrue(app.getComposeHelper().ifEmailNotSent());
        app.getComposeHelper().closePopUp();
    }




}
