package com.piotrskalski;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// The class that handles photo classification
public class PicturesClassificator {

    // An array that holds admissible file extensions
    private String[] allowedExtensions = {"jpg", "gif", "jpeg"};
    // The api instance that will be used for classification
    private Indico apiInstance;

    // =================================================================================================================

    // Constructor
    public PicturesClassificator(String apiKey) throws IndicoException {
        this.apiInstance =  new Indico(apiKey);
    }

    // =================================================================================================================

    // Method that handles photos sorting
    public void classify(String inputPath, String outputPath) throws FileIsNotPictureException,
                                                                GivenFolderDoesNotExistException,
                                                                IOException,
                                                                IndicoException
    {
        // Input and output handles
        File inputFolder = new File(inputPath);
        File outputFolder = new File(outputPath);

        // Array that holds paths to all photos that we want to classify
        String[] pathList = getPathsList(inputFolder);

        // API request
        BatchIndicoResult multiple = this.apiInstance.imageRecognition.predict(pathList);

        // Data structure that holds image features
        List<Map<String, Double>> imageRecognition = multiple.getImageRecognition();

        // Iterator that will help us to match the path to the file and the matching prediction
        int i = 0;

        // Iteration after projections for subsequent pictures
        for(Map<String, Double> predictions : imageRecognition) {

            // An iterator that will help us navigate the map
            Iterator<Map.Entry<String, Double>> it = predictions.entrySet().iterator();

            // Name of feature with maximum probability
            Map.Entry<String, Double> bestGuess = (Map.Entry)it.next();

            // Looping over features
            while (it.hasNext()) {
                Map.Entry<String, Double> pair = (Map.Entry)it.next();

                if(bestGuess.getValue() < pair.getValue()) {
                    bestGuess = pair;
                }
            }

            System.out.println(pathList[i] + ' ' + bestGuess.getKey());
            // Iterator increase
            i++;
        }

    }

    // =================================================================================================================

    // Method that returns list of paths to validated photo files
    private String[] getPathsList(File inputFolder) throws GivenFolderDoesNotExistException,
                                                            FileIsNotPictureException
    {

        // Verify whether input folder exists
        if(!inputFolder.exists() || !inputFolder.isDirectory()) throw new GivenFolderDoesNotExistException("Given path does not lead to existing directory.");

        // Array that holds input folder content
        File[] inputFolderContent = inputFolder.listFiles();

        // Array that will hold paths to all photos that we want to classify
        String[] pathList = new String[inputFolderContent.length];

        // Looping over input folder content
        for (int i = 0; i < inputFolderContent.length; i++) {

            // Current file name
            String fileName = inputFolderContent[i].getName();
            // Current file extension
            String ext = FilenameUtils.getExtension(fileName);

            // Verify if current file extension is allowed
            if(!isAllowed(ext)) throw new FileIsNotPictureException("Given file is not a picture");

            pathList[i] = inputFolderContent[i].getAbsolutePath();
        }

        return pathList;
    }

    // =================================================================================================================

    // Method that file extension is allowed
    private boolean isAllowed(String extension) {
        for(String str : allowedExtensions) {
            if(str.trim().contains(extension))
                return true;
        }
        return false;
    }
}
