package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(JokeApplication.class);
        //System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) {
        BorderPane mainLayout = new BorderPane();
        
        Label jokeLabel = new Label("What do you call a bear with no teeth?");
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Cause it has no teeth. Just gums :D");
        
        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mainLayout.setCenter(answerLayout);
            }    
        });
        
        jokeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mainLayout.setCenter(jokeLayout);
            }
        });
        
        explanationButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                mainLayout.setCenter(explanationLayout);
            }
        });
        
        mainLayout.setTop(menu);
        mainLayout.setCenter(jokeLabel);
        
        Scene scene = new Scene(mainLayout);
        
        
        
        window.setTitle("Jokes");
        window.setScene(scene);
        window.show();
    }
    
    private StackPane createView(String label) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(label));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    } 
}
