package com.piotrskalski;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
	    MicroDvd subtitles_operator = new MicroDvd();

        try {
            subtitles_operator.delay(args[0], args[1], 5000, 25);
        } catch (InvalidMethodArgumentsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidSubtitlesFormatException e) {
            e.printStackTrace();
        } catch (InvalidFramesOrderException e) {
            e.printStackTrace();
        } catch (NegativeFrameTimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
