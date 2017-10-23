package com.piotrskalski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Rot11 szyfr = new Rot11();

        String test = userInput.next();
        String zaszyfrowane = szyfr.crypt(test);
        System.out.println(zaszyfrowane);
        String odszyfrowane = szyfr.decrypt(zaszyfrowane);
        System.out.println(odszyfrowane);
    }
}
