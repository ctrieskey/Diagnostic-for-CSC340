import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Prototype_JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("This is a prototype");

        Stage destruction = new Stage();
        destruction.setTitle("It's not that easy...");

        Stage destruction2 = new Stage();
        destruction2.setTitle("You cant be serious...");

        Label label = new Label("BOOM!!!");
        //Group group = new Group();

        Button _button1 = new Button("1");
        Button _button2 = new Button("2");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");

        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);

        TilePane tilePane1 = new TilePane();
        tilePane1.setHgap(10);
        tilePane1.setVgap(10);

        tilePane.getChildren().add(button1);
        tilePane.getChildren().add(button2);
        tilePane.getChildren().add(button3);
        tilePane.getChildren().add(button4);
        tilePane.getChildren().add(button5);
        tilePane.getChildren().add(button6);

        tilePane1.getChildren().add(_button1);
        tilePane1.getChildren().add(_button2);

        Button dst = new Button("Destroy the World");

        Scene scene = new Scene(dst, 400, 100);
        Scene scene2 = new Scene(tilePane1, 400, 100);
        Scene scene3 = new Scene(tilePane, 400, 100);
        Scene boom = new Scene(label, 400, 200);

        dst.setOnAction(value -> {
            //label.setText("BOOM!!!!");
            destruction.setScene(scene2);

            primaryStage.close();

            destruction.show();

        });

        _button2.setOnAction(value -> {
            destruction2.setScene(scene3);

            destruction.close();

            destruction2.show();
        });
        
        button5.setOnAction(value ->{
            destruction2.setTitle("AHHHH ! ");
            destruction2.setScene(boom);
            
            
        });

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
