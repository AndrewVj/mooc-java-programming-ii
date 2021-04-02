package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        bottom.getChildren().addAll(letters, words, longestWord);
        
        TextArea textArea = new TextArea();
        componentGroup.setCenter(textArea);
        
        componentGroup.setBottom(bottom);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            String textTyped = newValue;
            letters.setText("Letters: "+textTyped.length());
            String[] wordsAfterSplit = textTyped.split(" ");
            words.setText("Words: "+wordsAfterSplit.length);
            String longest = Arrays.stream(wordsAfterSplit)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longestWord.setText("The longest word is: "+longest);
        });
        
        Scene scene = new Scene(componentGroup);
        window.setTitle("TextStatisticsApplication");
        window.setScene(scene);
        window.show();
    }

}
