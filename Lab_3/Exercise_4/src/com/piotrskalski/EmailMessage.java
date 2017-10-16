package com.piotrskalski;
import java.util.*;

public class EmailMessage {

    private String from;                    // required (must be e-mail)
    private LinkedList<String> to;          // required at least one (must be e-mail)
    private String subject;                 // optional
    private String content;                 // optional
    private String mimeType;                // optional
    private LinkedList<String> cc;          // optional
    private LinkedList<String> bcc;         // optional

    // CONSTRUCTOR
    private EmailMessage(String from_, LinkedList<String> to_, String subject_, String content_,
                        String mimeType_, LinkedList<String> cc_, LinkedList<String> bcc_){

        this.from = from_;
        this.to = to_;
        this.subject = subject_;
        this.content = content_;
        this.mimeType = mimeType_;
        this.cc = cc_;
        this.bcc = bcc_;
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

    // BCC
    public LinkedList<String> getBcc() { return bcc; }

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

    // INNER CLASS
    static public class Builder {

        private String fromTmp;
        private LinkedList<String> toTmp;
        private String subjectTmp;
        private String contentTmp;
        private String mimeTypeTmp;
        private LinkedList<String> ccTmp;
        private LinkedList<String> bccTmp;
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
                    this.bccTmp);
        }
    }


}
