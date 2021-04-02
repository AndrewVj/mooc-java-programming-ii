package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application{


    public static void main(String[] args) {
        launch(SmileyApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        Canvas paintingCanvas = new Canvas(500, 500);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.BLACK);
        painter.fillRect(125, 75, 50, 50);
        painter.fillRect(325, 75, 50, 50);
        painter.fillRect(75, 275, 50, 50);
        painter.fillRect(375, 275, 50, 50);
        painter.fillRect(125, 325, 250, 50);
        
        layout.setCenter(paintingCanvas);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setTitle("Smiley Application");
        window.show();
    }

}
