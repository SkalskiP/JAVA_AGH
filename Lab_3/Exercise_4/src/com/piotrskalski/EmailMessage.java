package com.piotrskalski;

import java.util.LinkedList;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailMessage {

    private String from;                    // required (must be e-mail)
    private LinkedList<String> to;          // required at least one (must be e-mail)
    private String subject;                 // optional
    private String content;                 // optional
    private String mimeType;                // optional
    private LinkedList<String> cc;          // optional
    private LinkedList<String> bcc;         // optional
    private String password;                // required

    // CONSTRUCTOR
    private EmailMessage(String from_, LinkedList<String> to_, String subject_, String content_,
                        String mimeType_, LinkedList<String> cc_, LinkedList<String> bcc_, String password_){

        this.from = from_;
        this.to = to_;
        this.subject = subject_;
        this.content = content_;
        this.mimeType = mimeType_;
        this.cc = cc_;
        this.bcc = bcc_;
        this.password = password_;
    }

    // FROM GETTER
    public String getFrom() { return this.from; }

    // TO GETTER
    public LinkedList<String> getTo() { return this.to; }

    // SUBJECT GETTER
    public String getSubject() { return this.subject; }

    // CONTENT GETTER
    public String getContent() { return this.content; }

    // MINE TYPE GETTER
    public String getMimeType() { return this.mimeType; }

    // CO GETTER
    public LinkedList<String> getCc() { return this.cc; }

    // BCC GETTER
    public LinkedList<String> getBcc() { return bcc; }

    // PASSWORD GETTER
    public String getPassword() { return this.password;}

    // FACTORY
    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    // TESTING EMAIL MESSAGE
    public void checkValues() {
        System.out.println("Values of EmailMassage fields:");
        if (this.from != null) {
            System.out.println("Nadawca: " + this.from);
        }
        if (this.password != null) {
            System.out.println("Hasło: " + this.password);
        }
        if (this.to != null) {
            System.out.println("Odbiorcy: " + this.to.toString());
        }
        if (this.subject != null) {
            System.out.println("Tytuł: " + this.subject);
        }
        if (this.content != null) {
            System.out.println("Treść: " + this.content);
        }
    }

    // SENDING MESSAGE
    public void send() throws MessagingException {
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.user", this.from);
        props.setProperty("mail.smtp.password", this.password);
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(this.from));

        for(String x: this.to)
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(x));

        message.setSubject(this.subject);

        message.setText(this.content);

        Transport.send(message);

        System.out.println("Message sent successfully");


    }

    // INNER CLASS
    static public class Builder {

        private String fromTmp;
        private LinkedList<String> toTmp;
        private String subjectTmp;
        private String contentTmp;
        private String mimeTypeTmp;
        private LinkedList<String> ccTmp;
        private LinkedList<String> bccTmp;
        private String passwordTmp;
        public String Pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        // CONSTRUCTOR
        public Builder() {
            this.fromTmp = null;
            this.toTmp = null;
            this.subjectTmp = null;
            this.contentTmp = null;
            this.mimeTypeTmp = null;
            this.ccTmp = null;
            this.bccTmp = null;
            this.passwordTmp = null;
        }

        // PASSWORD SETTER
        public Builder addPassword(String password) {
            this.passwordTmp = password;
            return this;
        }

        // SUBJECT SETTER
        public Builder addSubject(String subject) {
            this.subjectTmp = subject;
            return this;
        }

        // CONTENT SETTER
        public Builder addContent(String content) {
            this.contentTmp = content;
            return this;
        }

        // FROM SETTER
        public Builder addFrom(String from) throws InvalidEmailFormatException {
            if (Validator.validate(this.Pattern, from)) {
                this.fromTmp = from;
                return this;
            } else
                throw new InvalidEmailFormatException("Wrong email from in " + from);
        }

        // TO SETTER
        public Builder addTo(String... to) throws InvalidEmailFormatException {
            if (this.toTmp == null)
                this.toTmp = new LinkedList<String>();
            for (String tmp : to) {
                if (Validator.validate(this.Pattern, tmp)) {
                    toTmp.add(tmp);
                } else
                    throw new InvalidEmailFormatException("Wrong email from in " + tmp);
            }
            return this;
        }

        // CREATING EMAIL MESSAGE OBJECT
        public EmailMessage build() {
            return new EmailMessage(
                    this.fromTmp,
                    this.toTmp,
                    this.subjectTmp,
                    this.contentTmp,
                    this.mimeTypeTmp,
                    this.ccTmp,
                    this.bccTmp,
                    this.passwordTmp);
        }
    }


}
