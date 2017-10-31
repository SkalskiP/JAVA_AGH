package com.piotrskalski;

import io.indico. *;
import io.indico.api.utils.IndicoException;

public class Main {

    public static void main(String[] args) {

        PicturesClassificator classificator = new PicturesClassificator();

        try {
            classificator.classify(args[0], args[1]);
        } catch (FileIsNotPictureException e ) {
            e.printStackTrace();
        } catch (GivenFolderDoesNotExistException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }

    }
}
