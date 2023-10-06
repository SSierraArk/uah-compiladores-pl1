/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.HashMap;

/**
 *
 * @author ssierra
 */
public class State {
    
    protected HashMap<Character,Integer> delta;
    protected boolean isFinal = false;

    public State(HashMap<Character, Integer> delta) {
        this.delta = delta;
    }
    
    public boolean isFinal() {
    
        return isFinal;
    
    }
    
    public void setFinal() {
    
        isFinal = true;
    
    }
    
    public int next(char input) {
    
        if (!delta.containsKey(input)) {
        
            return -1;
            
        }
        
        return delta.get(input);
        
    }
    
    public HashMap<Character, Integer> getDelta() {
    
        return delta;
    
    }
        
}
