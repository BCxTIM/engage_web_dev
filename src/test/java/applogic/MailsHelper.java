package applogic;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public interface MailsHelper {
    void openLastEmail(String text);
    boolean verifySubject(String text);
    boolean verifyDescription(String text);
}
