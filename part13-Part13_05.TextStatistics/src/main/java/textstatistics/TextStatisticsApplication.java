package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        //System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) {
        BorderPane componentGroup = new BorderPane();
        HBox bottom = new HBox();
        bottom.setSpacing(10);
        bottom.getChildren().add(new Label("Letters: 0"));
        bottom.getChildren().add(new Label("Words: 0"));
        bottom.getChildren().add(new Label("The longest word is:"));
        componentGroup.setCenter(new TextArea(""));
        componentGroup.setBottom(bottom);
        
        Scene scene = new Scene(componentGroup);
        window.setTitle("TextStatisticsApplication");
        window.setScene(scene);
        window.show();
    }

}
