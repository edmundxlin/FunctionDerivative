package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int rex = 800;
        int rey = 800;

        VBox root = new VBox(5);
        Scene scene = new Scene(root, rex, rey);

        TextField userIn = new TextField();
       // userIn.setLayoutX(100);
        //userIn.setLayoutY(100);

        Label text = new Label();
        Button button = new Button("Submit");
        Derivative expressed = new Derivative();
        String input = userIn.getText();
        String expression = input;
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText(expressed.takeIn(userIn.getText()));
                text.setLayoutX(100);
                text.setLayoutY(100);
            }


        });


        root.getChildren().addAll(userIn,text, button);
        primaryStage.setTitle("Derived!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
