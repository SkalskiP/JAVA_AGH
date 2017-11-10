package sample;

import io.indico.api.utils.IndicoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TextField api_key;
    private File inputPath;

    public void submit(ActionEvent actionEvent) throws IOException {

        System.out.println(api_key.getText());
        System.out.println(inputPath.getAbsolutePath());

        try {
            PicturesClassificator classificator = new PicturesClassificator(api_key.getText());
            Main.predictions = classificator.classify(inputPath.getAbsolutePath());
            Main.pathList = classificator.pathList;
            Main.nameList = classificator.nameList;

        } catch (FileIsNotPictureException e ) {
            e.printStackTrace();
        } catch (GivenFolderDoesNotExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }

        Parent viewer_page_parent = FXMLLoader.load(getClass().getResource("ViewerPage.fxml"));
        Scene wiewer_page_scene = new Scene(viewer_page_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(wiewer_page_scene);
        app_stage.setWidth(900);
        app_stage.setHeight(500);
        app_stage.show();
    }

    public void chooseDirectory(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select directory");
        File defaultDirectory = new File("C:/");
        chooser.setInitialDirectory(defaultDirectory);
        inputPath = chooser.showDialog(new Stage());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

}
