package com.piotrskalski;

import java.io.File;
import java.util.Scanner;

public class Main {

    /*
    If you want to use this code on your computer you need to create three separate files on your computer.
    This files will hold:
    1. Text that you want to encrypt.
    2. Text after encryption.
    3. Text after decryption.

    Finally you need to provide paths to those files as arguments in program configurations.
    */

    public static void main(String[] args) {

        File in = new File(args[0]);
        File out = new File(args[1]);
        File encrypted = new File(args[2]);

        System.out.println("1.szyfruj(ROT11)");
        System.out.println("2.szyfruj(Polibiusz)");
        System.out.print("Wybor: ");
        Scanner userInput = new Scanner(System.in);
        int i = userInput.nextInt();
        switch (i) {
            case 1:
                Cryptographer.cryptFile(in, encrypted, new Rot11());
                Cryptographer.deCryptFile(encrypted, out, new Rot11());
                break;
            case 2:
                Cryptographer.cryptFile(in, encrypted, new Polibius());
                Cryptographer.deCryptFile(encrypted, out, new Polibius());
                break;
            default:
                Cryptographer.cryptFile(in, encrypted, new Rot11());
                Cryptographer.deCryptFile(encrypted, out, new Rot11());
                break;
        }
    }
}
