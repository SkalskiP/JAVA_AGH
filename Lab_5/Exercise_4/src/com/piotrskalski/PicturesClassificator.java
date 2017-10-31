package com.piotrskalski;

import io.indico. *;
import io.indico.api.utils.IndicoException;

public class PicturesClassificator {

    public void classify(String inputPath, String outputPath) throws FileIsNotPictureException,
                                                                GivenFolderDoesNotExistException,
                                                                IndicoException
    {
        Indico indico = new Indico("162e5af316869ead56c13fafb5462658");

        System.out.println(inputPath);
        System.out.println(outputPath);
    }
}
