package sample;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewerPageController implements Initializable {

    @FXML
    private ComboBox photos_list;
    @FXML
    private ImageView item_photo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        photos_list.getItems().removeAll(photos_list.getItems());
        photos_list.getItems().addAll(Main.nameList);
        photos_list.getSelectionModel().select(Main.nameList[Main.selectedId]);

        File file = new File(Main.pathList[Main.selectedId]);
        Image image = new Image(file.toURI().toString());
        item_photo.setImage(image);
    }


    public void test(ActionEvent actionEvent) {

        Main.selectedId = photos_list.getSelectionModel().getSelectedIndex();

        photos_list.getSelectionModel().select(Main.nameList[Main.selectedId]);

        File file = new File(Main.pathList[Main.selectedId]);
        Image image = new Image(file.toURI().toString());
        item_photo.setImage(image);
    }
}
