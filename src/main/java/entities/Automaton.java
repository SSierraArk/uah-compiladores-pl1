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
    
    /**
     * Creates an Automaton object from a given state matrix. <br>
     * 
     * This matrix must use the "," character as a column separator and ";"
     * for rows.
     * The first entry within the matrix is assumed to be the initial state.
     * 
     * @param inputAlphabet
     * @param stateMatrix 
     */
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
    
    /**
     * Creates an Automaton object from a given state matrix. <br>
     * 
     * This matrix must use the "," character as a column separator and ";"
     * for rows.
     * The first entry within the matrix is assumed to be the initial state.
     * 
     * @param inputAlphabet
     * @param stateMatrix 
     */
    public Automaton(String inputAlphabet, String stateMatrix, int[] finalStates) {
    
    
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
        this.setFinal(finalStates);
        
    
    }
    
    public Automaton(String inputAlphabet, String stateMatrix, int finalState) {
    
    
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
        this.setFinal(finalState);
        
    
    }
    
    /**
     * Returns the current state object.
     * @return 
     */
    public State getCurrentState() {
    
        return this.currentState;
    
    }
    
    /**
     * Returns current state index.
     * @return 
     */
    public int current() {
    
        return this.stateList.indexOf(currentState);
    
    }
    
    /**
     * Sets the i-th state within the stateList as being a final state.
     * @param index 
     */
    public void setFinal(int index) {
    
        stateList.get(index).setFinal();
    
    }
    
    /**
     * Sets i-th states within the stateList as being a final state. <br>
     * From a given array of indices.
     * @param index 
     */
    public void setFinal(int[] indices) {
    
        for (int index : indices) {
        
            stateList.get(index).setFinal();
        
        }
    
    }
    
    /**
     * Returns the automaton to its initial state.
     */
    public void reset() {
    
        this.currentState = stateList.get(0);
    
    }
    
    /**
     * 
     * @param index 
     */
    public void setCurrentState(int index) {
    
        this.currentState = stateList.get(index);
    
    }
    
    /**
     * Transitions to the following state based on a given input.
     * Does nothing if not defined within the transition function.
     * @param inputChar
     * @return 
     */
    public int next(char inputChar) {
    
        int index = currentState.next(inputChar);
        
        currentState = index >= 0
                ? stateList.get(currentState.next(inputChar)) 
                : currentState;
        
        return index;
    
    }
    
    public int seek(char inputChar) {
    
        return currentState.next(inputChar);
    }
    
    public String[] spanAlphabet(int length) {
    
        int dim = (int) Math.pow(this.inputAlphabet.length(), length);
        String[] out = new String[dim];

        // Initialise each entry for the below code to work as expected.
        for (int i = 0; i < dim; i++) out[i] = "";
        
        for (int j = 0; j < length; j++) {
            
            int intervalLength = (int) Math.pow(this.inputAlphabet.length(), length - j - 1);
            
            for (int i = 0; i < dim; i++) {
                
                
                out[i] += inputAlphabet.charAt(((int) i/intervalLength)%3);
            }
        }
        
        return out;
        
    }
    
    /**
     * Spans all valid strings for a given output length.
     * @param length
     * @return 
     */
    public ArrayList<String> span(int length) {
    
        ArrayList<String> out = new ArrayList<>();
        String[] alpha = this.spanAlphabet(length);
        
        for (String elem : alpha) {
            
            if (this.validate(elem)) out.add(elem);
        }
        
        return out;
    
    }
    
    public ArrayList<String> span(int length, int limit) {
    
        ArrayList<String> out = new ArrayList<>();
        String[] alpha = this.spanAlphabet(length);

        int i = 0;
        while (i < alpha.length && out.size() <= limit) {
        
        
            if (this.validate(alpha[i])) out.add(alpha[i]);
            i++;
        
        }

    
        
        return out;
    
    }
    
    /**
     * Spans all valid strings with lengSths growing up to a given limit.
     * @param lengthLim
     * @return 
     */
    public ArrayList<String> spanUntil(int lengthLim) {
    
        ArrayList<String> out = new ArrayList<>();
        for (int i = 1; i <= lengthLim; i++) {
        
            out.addAll(this.span(i));
        
        }
    
        return out;
    }
    
    
    public boolean validate(String input) {

        char[] inputArr = input.toCharArray();
        boolean isValid = true;
        int counter = 0;
        boolean isFinal;
        
        while (isValid && counter < inputArr.length) {
        
            if (this.next(inputArr[counter++]) < 0) {
            
                isValid = false;
            
            }
        
        }
        
        isFinal = currentState.isFinal();
        this.reset();
        
        return isValid && isFinal;
    }
        
    
}
