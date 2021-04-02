package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane firstView = new BorderPane();
        Button toSecondView = new Button("To second view");
        firstView.setTop(new Label("First View!"));
        firstView.setCenter(toSecondView);
        
        VBox secondView = new VBox();
        Button toThirdView = new Button("To third view");
        secondView.getChildren().add(toThirdView);
        secondView.getChildren().add(new Label("Second View!"));
        
        GridPane thirdView = new GridPane();
        Button toFirstView = new Button("To first view");
        thirdView.add(new Label("Third View!"), 0, 0);
        thirdView.add(toFirstView, 1, 1);
        
        Scene firstScene = new Scene(firstView);
        Scene secondScene = new Scene(secondView);
        Scene thirdScene = new Scene(thirdView);
        
        toSecondView.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.setScene(secondScene);
            }
            
        });
        
        toThirdView.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.setScene(thirdScene);
            }
            
        });
        
        toFirstView.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.setScene(firstScene);
            }
            
        });
        
        window.setTitle("Multiple Views");
        window.setScene(firstScene);
        window.show();
    }

}
