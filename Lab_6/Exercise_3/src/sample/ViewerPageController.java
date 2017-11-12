package sample;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewerPageController implements Initializable {

    @FXML
    private ComboBox photos_list;
    @FXML
    private ImageView item_photo;
    @FXML
    BarChart<String, Number> barChart;
    @FXML
    NumberAxis yAxis;
    @FXML
    CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        photos_list.getItems().removeAll(photos_list.getItems());
        photos_list.getItems().addAll(Main.nameList);
        photos_list.getSelectionModel().select(Main.nameList[Main.selectedId]);

        File file = new File(Main.pathList[Main.selectedId]);
        Image image = new Image(file.toURI().toString());
        item_photo.setImage(image);
        prepereChart(Main.predictions.get(Main.selectedId));
    }

    public void prepereChart(Map<String, Double> map) {
        barChart.getData().clear();

        barChart.setTitle("Image Classify");
        xAxis.setLabel("Category");
        xAxis.setTickLabelRotation(90);
        // yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();

        int i = 1;
        for (Map.Entry<String, Double> k :map.entrySet()){
            series1.getData().add(new XYChart.Data<String, Number>(trim(k.getKey(), 25),k.getValue()));
            System.out.println(k.getKey() + ' ' + k.getValue());
            if(i >= 5) break;
            i++;
        }

        barChart.getData().addAll(series1);
        System.out.println("-----------------------------------------------------");
    }

    public String trim(String label, int maxLen) {
        if(label.length() < maxLen) return label;
        else {
            return( label.substring(0, 22) + "..." );
        }
    }

    public void test(ActionEvent actionEvent) {

        Main.selectedId = photos_list.getSelectionModel().getSelectedIndex();

        photos_list.getSelectionModel().select(Main.nameList[Main.selectedId]);

        File file = new File(Main.pathList[Main.selectedId]);
        Image image = new Image(file.toURI().toString());
        item_photo.setImage(image);

        prepereChart(Main.predictions.get(Main.selectedId));
    }
}
