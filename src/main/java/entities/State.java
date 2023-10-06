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

    public State(HashMap<Character, Integer> delta) {
        this.delta = delta;
    }
    
    public int next(char input) {
    
        return delta.get(input);
        
    }
        
}
