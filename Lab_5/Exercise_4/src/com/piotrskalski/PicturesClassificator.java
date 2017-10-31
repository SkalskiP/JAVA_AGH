package com.piotrskalski;

import io.indico. *;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class PicturesClassificator {

    String[] allowedExtensions = {"jpg", "gif", "jpeg"};

    public void classify(String inputPath, String outputPath) throws FileIsNotPictureException,
                                                                GivenFolderDoesNotExistException,
                                                                IndicoException
    {
        Indico indico = new Indico("162e5af316869ead56c13fafb5462658");

        System.out.println(inputPath);
        System.out.println(outputPath);

        File f = new File(inputPath);
        // verify that the folder exists
        if(!f.exists() || !f.isDirectory()) throw new GivenFolderDoesNotExistException("Given path does not lead to existing directory.");

        for (final File fileEntry : f.listFiles()) {

            String fileName = fileEntry.getName();
            String ext = FilenameUtils.getExtension(fileName);

            if(!is_allowed(ext)) throw new FileIsNotPictureException("Given file is not a picture");
            String filePath = inputPath + fileName;

            IndicoResult single = indico.contentFiltering.predict(filePath);

        }

    }

    public boolean is_allowed(String extension) {
        for(String str : allowedExtensions) {
            if(str.trim().contains(extension))
                return true;
        }
        return false;
    }
}
