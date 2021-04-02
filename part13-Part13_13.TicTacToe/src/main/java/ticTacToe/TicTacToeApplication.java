package ticTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        //System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) throws Exception {
        
        window.setTitle("TicTacToe");
        BorderPane layout = new BorderPane();
        Label turnLabel = new Label("Turn: X");
        turnLabel.setFont(Font.font("Monospaced", 40));
        
        GridPane gridLayout = new GridPane();
        
        Button[][] buttons = new Button[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                gridLayout.add(button, i, j);
                buttons[i][j] = button;
            }
        }
        
        TicTacToeGame game = new TicTacToeGame(buttons, turnLabel);
        game.setEventHandling();
        
        gridLayout.setAlignment(Pos.CENTER);
        gridLayout.setPadding(new Insets(20,20,20,20));
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        
        layout.setTop(turnLabel);
        layout.setCenter(gridLayout);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        
    }
}
