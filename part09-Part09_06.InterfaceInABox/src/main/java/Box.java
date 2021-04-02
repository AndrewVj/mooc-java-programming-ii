
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrewvijay
 */
public class Box implements Packable{
    
    private ArrayList<Packable> items;
    private double maxCapacity;

    public Box(double maxCapacity) {
        this.items = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    
    public void add(Packable item) {
        if(item.weight() + this.weight() <= maxCapacity) {
            this.items.add(item);
        }
    }
    
    public double weight() {
        if(this.items.isEmpty()) {
            return 0.0;
        }
        double currentWeight = 0.0;
        for(Packable item: this.items) {
            currentWeight = currentWeight + item.weight();
        }
        
        return currentWeight;
    }
    
    @Override
    public String toString() {
        return "Box: "+this.items.size()+" items, total weight "+this.weight()+" kg";
    }
}
