package operateScreen;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * @author elyse on 05/11/2019
 * @project U5A1 Operate Screen
 */

public class IncrementTempController implements Initializable {

    //initialize textField currentTime
    @FXML
    TextField currentTime;

    //add initClock() method
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClock();
    }

    @FXML
    //location and resources will be automatically injected by the FXML loader
    private URL location;

    @FXML
    private ResourceBundle resources;

    //Public no-args constructor
    @FXML
    private void initialize(){

    }

    @FXML
    private Button fanButton;

    @FXML
    private Button systemButton;

    @FXML
    private RadioButton radioTempFahrenheit;

    @FXML
    private RadioButton radioTempCelsius;

    @FXML
    private TextField currentInsideRelativeHumidity;

    @FXML
    private TextField currentSetting;

    @FXML
    private String currentTemp = "72.0";

    @FXML
    private Button temperatureUp;

    @FXML
    private Button temperatureDown;

    @FXML
    private Button coolButton;

    @FXML
    private Button autoButton;

    @FXML
    private Button programButton;

    //Methods to operate buttons
    @FXML
    public void fanButtonPressed(){
        System.out.println("The fan is on/off.");
    }

    @FXML
    public void autoButtonPressed(){
        System.out.println("Auto is on/off.");
    }

    @FXML
    public void systemButtonPressed(){
        System.out.println("System is on/off.");
    }

    @FXML
    public void coolButtonPressed(){
        System.out.println("Cool is on/off.");
    }

    @FXML
    public void changeSetting(ActionEvent event) {
        //parse current temp to double
        double ct = Double.parseDouble(currentTemp);

        //use event handler or up down button
        //increment double current by one/decrement by one
        //convert ct to string and assign to current temp
        //current setting append text with current temp
        //access the textfield by using the textfield name dot setText()
        //use && to determine the max and min

        if (event.getSource() == temperatureUp && ct < 90) {
            ct++;
            currentTemp = String.valueOf(ct);
            currentSetting.setText(currentTemp);

        } else if (event.getSource() == temperatureDown && ct > 50) {
            ct--;
            currentTemp = String.valueOf(ct);
            currentSetting.setText(currentTemp);
        }
    }


    @FXML
    public void programOpen(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            //Path to FXML file
            String fxmlDocPath = "C:\\Users\\elyse\\IdeaProjects\\U5A1_OperateScreen\\src\\operateScreen\\ProgramScreen.fxml";

            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

            //Create the Pane and all the details
            Pane root = (Pane) fxmlLoader.load(fxmlStream);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 800));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initClock(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            currentTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


}


