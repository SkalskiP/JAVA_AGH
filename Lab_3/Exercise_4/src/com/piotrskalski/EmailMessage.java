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
    public String getFrom() {
        return this.from;
    }

    // TO GETTER
    public void getTo() {
        for (String singleTo : this.to)
            System.out.println(singleTo);
    }

    // CONSTRUCTOR
    public EmailMessage(String from,
                        LinkedList<String> to,
                        String subject,
                        String content,
                        String mimeType,
                        LinkedList<String> cc,
                        LinkedList<String> bcc){
        // wiele if, else, sprawdzania czy string jest e-mail, itd.
    }

    //FACTORY
    public static Builder builder() {
        return new EmailMessage.Builder();
    }

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
    }


}
