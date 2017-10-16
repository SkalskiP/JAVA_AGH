package com.piotrskalski;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) {
        try {
            EmailMessage email = EmailMessage.builder()
                    .addFrom("javamail2017agh@gmail.com")
                    .addTo("piotr.skalski92@gmail.com")
                    .addSubject("Temat testowej wiadomości")
                    .addContent("Treść testowej wiadomości")
                    .addPassword("javamail")
                    .build();
            email.checkValues();
            email.send();
        } catch (InvalidEmailFormatException e) {
            e.printStackTrace();
        } catch (MessagingException e ) {
            System.out.println("Messaging Exception");
        }
    }
}
