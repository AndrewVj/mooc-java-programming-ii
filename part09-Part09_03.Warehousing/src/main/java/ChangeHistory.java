
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrewvijay
 */
public class ChangeHistory {
    
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public double maxValue() {

        if(this.history.isEmpty()) {
            return 0.0;
        }
        
        double maxValue = this.history.get(0);
        for(double value: this.history) {
            if(maxValue <= value) {
                maxValue = value;
            }
        }
        
        return maxValue;
    }
    
    public double minValue() {
        
        if(this.history.isEmpty()) {
            return 0.0;
        }
        
        double minValue = this.history.get(0);
        for(double value: this.history) {
            if(minValue >= value) {
                minValue = value;
            }
        }
        
        return minValue;
    }
    
    public double average() {
        
        if(this.history.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for(double value: this.history) {
            sum = sum + value;
        }
        
        return sum / this.history.size();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
}
