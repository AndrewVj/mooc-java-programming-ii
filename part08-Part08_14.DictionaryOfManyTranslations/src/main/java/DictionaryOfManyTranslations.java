
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
public class DictionaryOfManyTranslations {
    
    private HashMap<String, ArrayList<String>> dictOfTranslations;

    public DictionaryOfManyTranslations() {
        this.dictOfTranslations = new HashMap<>();
    }
    
    public void add(String word, String translation)  {
        this.dictOfTranslations.putIfAbsent(word, new ArrayList<>());
        
        ArrayList<String> translations = this.dictOfTranslations.get(word);
        translations.add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return this.dictOfTranslations.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        this.dictOfTranslations.remove(word);
    }
    
}
