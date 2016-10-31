package model;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class ComposeModel {

    private String toEmail;
    private String subject;
    private String description;

    public String getToEmail() {
        return toEmail;
    }

    public ComposeModel setToEmail(String toEmail) {
        this.toEmail = toEmail;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ComposeModel setSubjecField(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ComposeModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
