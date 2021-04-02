/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.scene.control.Button;

/**
 *
 * @author andrewvijay
 */
public class SquareButton {
    
    private Button button;
    private int value;

    public SquareButton(Button button) {
        this.button = button;
        this.value = 0;
    }
    
    public void setSquareValue(String XorO) {
        if(XorO.equals("X")) {
            this.value = 1;
        }
        if(XorO.equals("O")) {
            this.value = 7;
        }
    }

    public Button getButton() {
        return button;
    }

    public int getValue() {
        return value;
    }

}
