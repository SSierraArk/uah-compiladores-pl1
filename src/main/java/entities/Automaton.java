/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.ssierra.uah.compiladores.pl1.util.MatrixParser;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ssierra
 */
public class Automaton {
    
    protected String inputAlphabet;
    protected ArrayList<State> stateList;
    protected State currentState;
    
    public Automaton(String inputAlphabet, ArrayList<State> stateList) {
        
        this.inputAlphabet = inputAlphabet;
        this.stateList = stateList;
        
    }
    
    public Automaton(String inputAlphabet, String stateMatrix) {
    
    
        this.inputAlphabet = inputAlphabet;
        
        ArrayList<State> stateList = new ArrayList<>();
        int[][] matrix = MatrixParser.parseMatrix(stateMatrix);
        
        // Iterate rows
        for (int[] row : matrix) {
        
            HashMap<Character, Integer> hm =  new HashMap<>();
            
            for (int i = 0; i < row.length; i++) {
            
                hm.put(inputAlphabet.charAt(i), row[i]);
            
            }
            
            stateList.add(new State(hm));
            
        
        }
        
        this.stateList = stateList;
        this.currentState = stateList.get(0);
        
    
    }
    
    public State getCurrentState() {
    
        return this.currentState;
    
    }
    
    public int current() {
    
        return this.stateList.indexOf(currentState);
    
    }
    
        
    
}
