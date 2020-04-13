package GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * The diagnosticInterface class provides a GUI for the vehicle diagnostic
 * program.
 *
 * Last Updated: 3/11/2020
 * @author Lavante Hammond
 */

public class DiagnosticInterface extends Application{

    //Override primaryStage method of Application class
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Set title of window
        primaryStage.setTitle("Vehicle Diagnostic");

        //Create gridpane for formatting purposes
        GridPane gridpane = new GridPane();

        //Labels are used to descrpibe text fields
        Label vin = new Label("VIN:");
        Label mileage = new Label("Mileage:");
        Label dtcCode = new Label("DTC Code:");

        //Text fields obtain input from users
        TextField vinInput = new TextField();
        TextField mileageInput = new TextField();
        TextField dtcCodeInput = new TextField();

        //Button used to obtain diagnostic
        Button diagnose = new Button("Diagnose");

        //Add elements to gridpane
        gridpane.add(vin, 0, 1);
        gridpane.add(mileage,0,2);
        gridpane.add(dtcCode, 0, 3);
        gridpane.add(vinInput,1,1);
        gridpane.add(mileageInput,1,2);
        gridpane.add(dtcCodeInput,1,3);
        gridpane.add(diagnose, 1, 5);


        //Displays scene for the GUI
        Scene display = new Scene(gridpane, 400, 400);

        //Displays GUI
        primaryStage.setScene(display);
        primaryStage.show();
    }

    //Main mehtod used to test GUI display
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}