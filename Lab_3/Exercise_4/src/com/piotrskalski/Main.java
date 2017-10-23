package com.piotrskalski;

import javax.mail.MessagingException;
import java.util.Scanner;

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

//    public static void main(String[] args) {
//        // Object that will handle creation of EmailMessage
//        EmailMessage.Builder emailBuilder = EmailMessage.builder();
//        // Object that will handle reading information from user
//        Scanner emailScanner = new Scanner(System.in);
//
//        // Variable that will trigger program termination
//        boolean running = true;
//        // Variable that will trigger email sending
//        boolean send = false;
//
//        // Main loop
//        while (running) {
//            System.out.print("- - - - - - - - - - - - - - - - - - - - - -\n" +
//                    "1. Create New Email\n" +
//                    "2. Check Email Parameters\n" +
//                    "3. Send Email\n" +
//                    "4. Abort\n" +
//                    "- - - - - - - - - - - - - - - - - - - - - -\n");
//
//            System.out.print("Wybierz opcję... ");
//            int selected = emailScanner.nextInt();
//
//            switch (selected) {
//                case 2:
//                    emailBuilder.checkValues();
//                    break;
//                case 3:
//                    EmailMessage email = emailBuilder.build();
//                    try {
//                        email.send();
//                    } catch(MessagingException e) {
//                        System.out.println("Sending failed.");
//                    }
//                    break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
}
