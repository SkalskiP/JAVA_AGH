package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Main extends Application {

    public static List<Map<String, Double>> predictions;
    public static String[] pathList;
    public static String[] nameList;
    public static int selectedId;

    @Override
    public void start(Stage primaryStage) throws Exception{
        selectedId = 0;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Photos classification");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
