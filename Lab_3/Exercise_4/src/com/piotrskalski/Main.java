package com.piotrskalski;

public class Main {

    public static void main(String[] args) {
        try {
            EmailMessage email = EmailMessage.builder()
                    .addFrom("piotr.skalski92@gmail.com")
                    .addTo("test@test.com", "test2@test.com")
                    .addSubject("Temat testowej wiadomości")
                    .addContent("Treść testowej wiadomości")
                    .build();
            email.checkValues();
        } catch (InvalidEmailFormatException e) {
            e.printStackTrace();
        }
    }
}
