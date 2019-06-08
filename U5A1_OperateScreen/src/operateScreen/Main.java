package operateScreen;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();

        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\elyse\\IdeaProjects\\U5A1_OperateScreen\\src\\operateScreen\\GUIView.fxml";

        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        //Create the Pane and all the details
        Pane root = (Pane) loader.load(fxmlStream);

//        Parent root = FXMLLoader.load(getClass().getResource("GUIView.fxml"));

        primaryStage.setTitle("Operate Screen");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
