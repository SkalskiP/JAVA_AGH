package com.piotrskalski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDvd {

    // constant pattern for matching
    private static final Pattern PATTERN = Pattern.compile("\\{([0-9]*)}\\{([0-9]*)}([^\\r\\n]*)");

    // =================================================================================================================

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

        // variable declaration that will hold the current line
        String currentLine;

        // looping over input file
        while(fileReader.hasNextLine()){

            // extracting a new line from the text
            currentLine = fileReader.nextLine();
            // building an matcher object that will help us perform the operations on the pattern
            Matcher matcher = PATTERN.matcher(currentLine);

            // validation whether current line fits to pattern
            if(!matcher.matches()) {
                throw new InvalidSubtitlesFormatException();
            }

            // extracting start and end frame numbers
            int startFrame = Integer.parseInt(matcher.group(1));
            int endFrame = Integer.parseInt(matcher.group(2));

            // validation whether order of frames is correct
            if(startFrame > endFrame) {

            }
        }

        // closing files streams
        fileReader.close();
        fileWriter.close();
    }

}
