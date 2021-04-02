package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application{


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) {
        BorderPane componentGroup = new BorderPane();
        componentGroup.setTop(new Label("NORTH"));
        componentGroup.setBottom(new Label("SOUTH"));
        componentGroup.setRight(new Label("EAST"));
        
        Scene scene = new Scene(componentGroup);
        window.setTitle("BorderPane");
        window.setScene(scene);
        window.show();
    }

}
