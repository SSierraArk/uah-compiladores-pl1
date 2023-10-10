/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ssierra.uah.compiladores.pl1;

import entities.Automaton;

/**
 *
 * @author ssierra
 */
public class Main {

    public static void main(String[] args) {

        Automaton automatonRegex1 = new Automaton("abc", "1,-1,2;-1,-1,2;4,3,4;2,-1,-1;-1,-1,-1", 4);
        
        Automaton automatonRegex2 = new Automaton("abc", "1,-1,-1;-1,2,-1;-1,-1,3;1,4,-1;-1,5,-1;5,-1,-1", 5);
        
        System.out.println("Validating RegEx I - Expressions 'acc' and 'cbabababaa': " +
                automatonRegex1.validate("acc") + " | " + automatonRegex1.validate("cbabababaa"));
        System.out.println("Validating RegEx II - Expressions 'abcbb' and 'abcabcbbaa': " +
                automatonRegex2.validate("abcbb") + " | " + automatonRegex2.validate("abcabcbbaa"));
        
        System.out.println("Valid strings: " + automatonRegex1.spanUntil(10));
        System.out.println("Valid strings: " + automatonRegex2.spanUntil(10));

    }
}
