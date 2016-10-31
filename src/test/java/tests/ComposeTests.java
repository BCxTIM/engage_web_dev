package tests;

import model.ComposeModel;
import model.LoginModel;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TestBase;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ComposeTests extends TestBase {


    private static final Logger logger = Logger.getLogger(ComposeTests.class);

    private String email = "timofei.moiseev88@gmail.com";
    private String password = "nWrjvyRevT1";
    private String subject = "Test";
    private String description = "Test description";

    @BeforeClass
    public void loginAsUser() throws Exception {
        PropertyConfigurator.configure("Log4j.properties");

        LoginModel loginModel = new LoginModel()
                .setEmail(email)
                .setPassword(password);
        app.getLoginHelper().loginAs(loginModel);
        logger.info("Logging as user");
        assertTrue(app.getLoginHelper().ifUserLogin());
        logger.info("Assert if user is log in");

    }

    @Test
    public void composeEmailOk() throws Exception {
        ComposeModel composeModel = new ComposeModel()
                .setToEmail(email)
                .setSubjecField(subject)
                .setDescription(description);
        app.getComposeHelper().composeEmail(composeModel);
        logger.info("Compose email");
        assertTrue(app.getComposeHelper().ifEmailSent());
        logger.info("Verify that email was sent");
    }

    @Test(dependsOnMethods = "composeEmailOk")
    public void verifySentEmail() throws Exception {
        app.getMailsHelper().openLastEmail(subject);
        logger.info("Open last email sent");
        assertTrue(app.getMailsHelper().verifySubject(subject));
        logger.info("Verify subject");
        assertTrue(app.getMailsHelper().verifyDescription(description));
        logger.info("Verify description");
    }

    @Test(dependsOnMethods = "verifySentEmail")
    public void composeEmailWithEmptyFields() throws Exception {
        ComposeModel composeModel = new ComposeModel()
                .setToEmail("")
                .setSubjecField("")
                .setDescription("");
        app.getComposeHelper().composeEmail(composeModel);
        logger.info("Try to send email without subject, description, and email address");
        assertTrue(app.getComposeHelper().ifEmailNotSent());
        logger.info("Verify that appear error message");
        app.getComposeHelper().closePopUp();
        logger.info("Close popup");
    }




}
