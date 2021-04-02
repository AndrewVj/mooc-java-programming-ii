
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
public class BoxWithMaxWeight extends Box {
    
    private int maxWeight;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.items = new ArrayList<>();
        super.add(items);
    }

    @Override
    public void add(Item item) {
        if(this.isInBox(item)) {
            return;
        }
        
        if(currentWeight() + item.getWeight() > this.maxWeight) {
            return;
        }
        
        this.items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
    
    public int currentWeight() {
        int currentWeight = 0;
        for(Item item: this.items) {
            currentWeight = currentWeight + item.getWeight();
        }
        return currentWeight;
    }
}
