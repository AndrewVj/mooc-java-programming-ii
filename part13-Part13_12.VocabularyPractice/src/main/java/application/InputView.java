/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author andrewvijay
 */
public class InputView {
    
    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        
        Label wordLabel = new Label("Word");
        TextField wordText = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationText = new TextField();
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20,20,20,20));
        
        Button addButton = new Button("Add the word pair");
        
        layout.add(wordLabel, 0, 0);
        layout.add(wordText, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationText, 0, 3);
        layout.add(addButton, 0, 4);
        
        addButton.setOnMouseClicked((event) -> {
            String wordField = wordText.getText();
            String translationField = translationText.getText();
            
            dictionary.add(wordField, translationField);
            
            wordText.clear();
            translationText.clear();
        });
        
        return layout;
    }
    
}
