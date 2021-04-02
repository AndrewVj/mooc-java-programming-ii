
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrewvijay
 */
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storageUnits;

    public StorageFacility() {
        this.storageUnits = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.storageUnits.putIfAbsent(unit, new ArrayList<>());
        
        ArrayList<String> contents = this.storageUnits.get(unit);
        contents.add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> contents = this.storageUnits.get(storageUnit);
        contents.remove(item);
        if(contents.isEmpty()) {
            this.storageUnits.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> unitNames = new ArrayList<>();
        for(String unitName: this.storageUnits.keySet()) {
            if(this.storageUnits.get(unitName).isEmpty()) {
                continue;
            }
            unitNames.add(unitName);
        }
        return unitNames;
    }
}
