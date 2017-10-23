package com.piotrskalski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Polibius szyfr = new Polibius();

        String test = userInput.next();
        String zaszyfrowane = szyfr.crypt(test);
        System.out.println(zaszyfrowane);
        String odszyfrowane = szyfr.decrypt(zaszyfrowane);
        System.out.println(odszyfrowane);
    }
}
