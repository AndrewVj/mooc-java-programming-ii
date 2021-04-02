/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrewvijay
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }
    
    public String history() {
        return this.history.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        double newBalance = super.getBalance();
        this.history.add(newBalance);
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double amt = super.takeFromWarehouse(amount);
        double newBalance = super.getBalance();
        this.history.add(newBalance);
        return amt;
    }
    
    public void printAnalysis() {
        System.out.println("Product: "+super.getName());
        System.out.println("History: "+this.history());
        System.out.println("Largest amount of product: "+this.history.maxValue());
        System.out.println("Smallest amount of product: "+this.history.minValue());
        System.out.println("Average: "+this.history.average());
    }
}
