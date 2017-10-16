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

    // CONSTRUCTOR
    public EmailMessage(String from_, LinkedList<String> to_, String subject_, String content_,
                        String mimeType_, LinkedList<String> cc_, LinkedList<String> bcc_){

        this.from = from_;
        this.to = to_;
        this.subject = subject_;
        this.content = content_;
        this.mimeType = mimeType_;
        this.cc = cc_;
        this.bcc = bcc_;
    }

    // FACTORY
    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    // TESTING EMAIL MESSAGE

    // INNER CLASS
    static public class Builder {

        private String fromTmp;
        private LinkedList<String> toTmp;
        private String subjectTmp;
        private String contentTmp;
        private String mimeTypeTmp;
        private LinkedList<String> ccTmp;
        private LinkedList<String> bccTmp;

        // CONSTRUCTOR
        public Builder() {
            this.fromTmp = null;
            this.toTmp = null;
            this.subjectTmp = null;
            this.contentTmp = null;
            this.mimeTypeTmp = null;
            this.ccTmp = new LinkedList<String>();
            this.bccTmp = new LinkedList<String>();
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

        // SENDER
    }


}
