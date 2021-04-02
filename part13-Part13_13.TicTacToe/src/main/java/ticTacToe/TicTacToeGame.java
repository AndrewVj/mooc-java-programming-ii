/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author andrewvijay
 */
public class TicTacToeGame {
    
    private SquareButton[][] buttons;
    private int counter;
    private Label turnLabel;

    public TicTacToeGame(Button[][] buttons, Label turnLabel) {
        this.buttons = setButtons(buttons);
        this.counter = 0;
        this.turnLabel = turnLabel;
    }
    
    private SquareButton[][] setButtons(Button[][] buttons) {
        SquareButton[][] allButtons = new SquareButton[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                allButtons[i][j] = new SquareButton(buttons[i][j]);
            }
        }
        
        return allButtons;
    }
    
    private void incrementCount() {
        if(this.isGameOver()) {
            return;
        }
        this.counter++;
    }
    
    private String whoseTurn() {
        if(this.counter % 2 == 0) {
            return "X";
        }
        return "O";
    }
    
    public void setEventHandling() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Button button = this.buttons[i][j].getButton();
                SquareButton square = this.buttons[i][j];
                button.setOnAction((event) -> {
                    
                    if(!button.getText().equals(" ")) {
                        return;
                    }
                    button.setText(this.whoseTurn());
                    square.setSquareValue(this.whoseTurn());
                    this.incrementCount();
                    if(this.isGameOver()) {
                        this.turnLabel.setText("The end!");
                        return;
                    }
                    this.turnLabel.setText("Turn: "+this.whoseTurn());
                });
            }
        }
    }
    
    private boolean isGameOver() {
        if(this.counter == 9) {
            return true;
        }
        
        if(this.getSumsOfRows().contains(3) || this.getSumsOfRows().contains(21)) {
            return true;
        }
        
        if(this.getSumsOfDiagnols().contains(3) || this.getSumsOfDiagnols().contains(21)) {
            return true;
        }
        
        if(this.getSumsOfCols().contains(3) || this.getSumsOfCols().contains(21)) {
            return true;
        }
        return false;
    }
    
    private ArrayList<Integer> getSumsOfDiagnols() {
        ArrayList<Integer> sums = new ArrayList<>();
        int diagSumOne = 0;
        int diagSumTwo = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) {
                    diagSumOne += this.buttons[i][j].getValue();
                }
                if(j == (2 - i)) {
                    diagSumTwo += this.buttons[i][j].getValue();
                }
            }
        }
        sums.add(diagSumOne);
        sums.add(diagSumTwo);
        return sums;
    }
    
    private ArrayList<Integer> getSumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            int sumOfRow = 0;
            for(int j = 0; j < 3; j++) {
                sumOfRow += this.buttons[i][j].getValue();
            }
            sums.add(sumOfRow);
        }
        return sums;
    }
    
    private ArrayList<Integer> getSumsOfCols() {
        ArrayList<Integer> sums = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            int sumOfCols = 0;
            for(int j = 0; j < 3; j++) {
                sumOfCols += this.buttons[j][i].getValue();
            }
            sums.add(sumOfCols);
        }
        return sums;
    }
}
