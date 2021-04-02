package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(GreeterApplication.class);
        //System.out.println("Hellow world! :3");
    }

    @Override
    public void start(Stage window) {
        Label label = new Label("Enter name and click Start");
        TextField textField = new TextField();
        Button start = new Button("Start");
        Label secondLabel = new Label();
        
        GridPane firstLayout = new GridPane();
        firstLayout.add(label, 0, 1);
        firstLayout.add(textField, 0, 2);
        firstLayout.add(start, 0, 3);

        
        firstLayout.setPrefSize(300, 180);
        firstLayout.setVgap(10);
        firstLayout.setHgap(10);
        firstLayout.setAlignment(Pos.CENTER);
        
        GridPane secondLayout = new GridPane();
        secondLayout.add(secondLabel, 0, 1);
        
        secondLayout.setPrefSize(300, 180);
        secondLayout.setVgap(10);
        secondLayout.setHgap(10);
        secondLayout.setAlignment(Pos.CENTER);
        
        Scene firstScene = new Scene(firstLayout);
        Scene secondScene = new Scene(secondLayout);
        
        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String name = textField.getText();
                if(name.isBlank()) {
                    return;
                }
                secondLabel.setText("Welcome "+name+"!");
                window.setScene(secondScene);
            }  
        });
        
        window.setTitle("Greeter");
        window.setScene(firstScene);
        window.show();
    }
}
