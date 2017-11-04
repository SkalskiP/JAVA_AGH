package com.piotrskalski;

import io.indico. *;
import io.indico.api.utils.IndicoException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            PicturesClassificator classificator = new PicturesClassificator("162e5af316869ead56c13fafb5462658");

            try {
                classificator.classify(args[0], args[1]);
            } catch (FileIsNotPictureException e ) {
                e.printStackTrace();
            } catch (GivenFolderDoesNotExistException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IndicoException e) {
            e.printStackTrace();
        }
    }
}
