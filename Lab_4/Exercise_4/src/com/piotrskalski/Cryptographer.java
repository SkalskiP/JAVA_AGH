package com.piotrskalski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cryptographer {

    public static void support(File inputPath, File outputPath, Algorithm method, String operation) {
        try {
            // an object that handles reading from a file
            Scanner fileReader = new Scanner(new FileReader(inputPath));

            // an object that handles writing to a file
            PrintWriter printWriter = new PrintWriter(outputPath);

            // iterate through the lines of the file
            while (fileReader.hasNextLine()){

                // a variable that holds an encrypted line of code
                StringBuilder lineResult = new StringBuilder();

                // single line from input file
                String line = fileReader.nextLine();

                // splitting line into separate words
                String[] splited = line.split("\\s+");

                // iteration over words in line
                for (String word : splited) {

                    if (operation == "crypt") {
                        // adding encrypted word with space
                        lineResult.append(method.crypt(word) + ' ');
                    } else if (operation == "decrypt") {
                        // adding decrypted word with space
                        lineResult.append(method.decrypt(word) + ' ');
                    }
                }

                // removing extra space at the end of line
                lineResult.setLength(lineResult.length() - 1);

                // saving encrypted line to file
                printWriter.println(lineResult.toString());

            }
            printWriter.close();
            fileReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    // =================================================================================================================

    public static void cryptFile(File inputPath, File outputPath, Algorithm crypterMethod){
        support(inputPath, outputPath, crypterMethod, "crypt");
    }

    // =================================================================================================================

    public static void deCryptFile(File inputPath, File outputPath, Algorithm methodDeCrypter){
        support(inputPath, outputPath, methodDeCrypter, "decrypt");
    }

}