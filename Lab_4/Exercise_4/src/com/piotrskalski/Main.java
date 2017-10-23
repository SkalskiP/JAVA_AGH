package com.piotrskalski;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File in = new File("C:\\Users\\AFGHAN92\\Desktop\\in.txt");
        File out = new File("C:\\Users\\AFGHAN92\\Desktop\\out.txt");
        File encrypted = new File("C:\\Users\\AFGHAN92\\Desktop\\encrypted.txt");

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
