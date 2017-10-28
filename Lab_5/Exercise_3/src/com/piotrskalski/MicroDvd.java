package com.piotrskalski;

// allows you to open files
import java.io.File;
// generic exception indicating missing file
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MicroDvd {

    // method that allows delay (or acceleration) of the subtitle by the specified number of milliseconds
    public void delay(String inputPath, String outputPath, int delay, int fps)  throws InvalidMethodArgumentsException,
                                                                                FileNotFoundException,
                                                                                InvalidSubtitlesFormatException  {
        // variables that hold handles to input and output files
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        // object that handles reading from a file
        Scanner fileReader = new Scanner(new FileReader(inputFile));
        // an object that handles writing to a file
        PrintWriter fileWriter = new PrintWriter(outputFile);

        

        // closing files streams
        fileReader.close();
        fileWriter.close();
    }

}
