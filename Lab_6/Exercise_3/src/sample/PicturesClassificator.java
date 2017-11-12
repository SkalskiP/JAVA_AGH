package sample;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.util.*;

// The class that handles photo classification
public class PicturesClassificator {

    // An array that holds admissible file extensions
    private String[] allowedExtensions = {"jpg", "gif", "jpeg"};
    // The api instance that will be used for classification
    private Indico apiInstance;

    public String[] pathList;
    public String[] nameList;

    // =================================================================================================================

    // Constructor
    public PicturesClassificator(String apiKey) throws IndicoException {
        // Initiating an api instance
        this.apiInstance = new Indico(apiKey);
    }

    // =================================================================================================================

    // Method that handles photos sorting
    public List<Map<String, Double>> classify(String inputPath) throws FileIsNotPictureException,
            GivenFolderDoesNotExistException,
            IOException,
            IndicoException {

        // Input handles
        File inputFolder = new File(inputPath);

        // Array that holds paths to all photos that we want to classify
        String[] pathList = getPathsList(inputFolder);

        List<Map<String, Double>> labels = make_request(pathList);

        return labels;
    }

    // =================================================================================================================

    // Method that returns HashMap with classifications
    private List<Map<String, Double>> make_request(String[] pathList) throws IndicoException, IOException {

        // API request
        BatchIndicoResult multiple = this.apiInstance.imageRecognition.predict(pathList);

        // Data structure that holds image features
        List<Map<String, Double>> imageRecognition = multiple.getImageRecognition();

        // Data structure that will hold selected values from map of all predictions
        List<Map<String, Double>> bestFits = new ArrayList<Map<String, Double>>();

//        // =============================================================================================================
//        // Selecting best fitting predictions for each photo
//        // =============================================================================================================
//
//        // Iteration over list containing predictions for all photos
//        for(Map<String, Double> singlePhoto : imageRecognition) {
//            // Initiation of new HashMap that will hold predictions with probability over selected value
//            Map<String, Double> selectedResults = new HashMap<>();
//
//            // Iteration over hashMap with all predictions
//            for(Map.Entry<String, Double> entry: singlePhoto.entrySet()){
//                // Validation of
//                if(entry.getValue() > 0.05){
//                    selectedResults.put(entry.getKey(), entry.getValue());
//                }
//            }
//            bestFits.add(selectedResults);
//        }


        // =============================================================================================================
        // Selecting best fitting predictions for each photo
        // =============================================================================================================

        // Iteration over list containing predictions for all photos
        for(Map<String, Double> singlePhoto : imageRecognition) {
            // Initiation of new HashMap that will hold predictions with probability over selected value
            Map<String, Double> result = new LinkedHashMap<>();
            singlePhoto.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

            bestFits.add(result);
        }

        return bestFits;
    }

    // =================================================================================================================

    // Method that returns list of paths to validated photo files
    private String[] getPathsList(File inputFolder) throws GivenFolderDoesNotExistException,
            FileIsNotPictureException {

        // Verify whether input folder exists
        if (!inputFolder.exists() || !inputFolder.isDirectory())
            throw new GivenFolderDoesNotExistException("Given path does not lead to existing directory.");

        // Array that holds input folder content
        File[] inputFolderContent = inputFolder.listFiles();

        // Array that will hold paths to all photos that we want to classify
        String[] pathList = new String[inputFolderContent.length];

        // Array that will hold names of all photos that we want to classify
        String[] namesList = new String[inputFolderContent.length];

        // Looping over input folder content
        for (int i = 0; i < inputFolderContent.length; i++) {

            // Current file name
            String fileName = inputFolderContent[i].getName();
            // Current file extension
            String ext = FilenameUtils.getExtension(fileName);

            // Verify if current file extension is allowed
            if (!isAllowed(ext)) throw new FileIsNotPictureException("Given file is not a picture");

            pathList[i] = inputFolderContent[i].getAbsolutePath();
            namesList[i] = inputFolderContent[i].getName();
        }

        this.pathList = pathList;
        this.nameList = namesList;
        return pathList;
    }

    // =================================================================================================================

    // Method that file extension is allowed
    private boolean isAllowed(String extension) {
        for (String str : allowedExtensions) {
            if (str.trim().contains(extension))
                return true;
        }
        return false;
    }
}
