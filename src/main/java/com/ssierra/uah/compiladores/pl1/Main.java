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

        Automaton automaton = new Automaton("abc", "1,-1,2;-1,-1,2;4,3,4;2,-1,-1;-1,-1,-1", 4);
        
        Automaton automaton_regex2 = new Automaton("abc", "1,-1,-1;-1,2,-1;-1,-1,3;1,4,-1;-1,5,-1;5,-1,-1", 5);
        
        System.out.println("Validating RegEx I: " + automaton.validate("acc"));
        System.out.println("Validating RegEx II: " + automaton_regex2.validate("abcbb"));
        
        System.out.println("Valid strings: " + automaton.spanUntil(15));
        System.out.println("Valid strings: " + automaton_regex2.span(5));

        
        System.out.println(automaton.validate("acc"));


    }
}
