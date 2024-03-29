
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    
    @Override
    public boolean equals(Object comparedObject) {
        
        if(this == comparedObject) {
            return true;
        }
        
        if(!(comparedObject instanceof LicensePlate)) {
            return false;
        }
        
        LicensePlate comparedPlate = (LicensePlate) comparedObject;
        
        return this.country.equals(comparedPlate.country) && this.liNumber.equals(comparedPlate.liNumber);
    }
    
    @Override
    public int hashCode() {
        
        if(this.country == null) {
            return this.country.hashCode();
        }
        
        return this.country.hashCode()+this.liNumber.hashCode();
    }

}
