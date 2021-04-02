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
public class PracticeView {
    
    private Dictionary dictionary;
    private String randomWord;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.randomWord = dictionary.getRandomWord();
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        Label instruction = new Label("Translate the word '"+this.randomWord+"'");
        TextField translation = new TextField();
        
        Button checkTranslation = new Button("Check");
        Label feedback = new Label();
        
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(20,20,20,20));
        
        layout.add(instruction, 0, 0);
        layout.add(translation, 0, 1);
        layout.add(checkTranslation, 0, 2);
        layout.add(feedback, 0, 3);
        
        checkTranslation.setOnMouseClicked((event) -> {
            String toCheck = translation.getText();
            if(this.dictionary.get(this.randomWord).equals(toCheck)) {
                feedback.setText("Correct!!");
            } else {
                feedback.setText("Incorrect! The translation fo the word '"+this.randomWord+"' is '"+this.dictionary.get(this.randomWord)+"'.");
                return;
            }
            
            this.randomWord = this.dictionary.getRandomWord();
            instruction.setText("Translate the word '"+this.randomWord+"'");
            translation.clear();
        });
        
        return layout;
    }
    
}
