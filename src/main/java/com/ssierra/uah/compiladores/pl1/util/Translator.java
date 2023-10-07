/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssierra.uah.compiladores.pl1.util;

import java.util.ArrayList;

/**
 *
 * @author ssierra
 */
public class Translator {
    
    /**
     *              Equivalencias de ER de teoría a ER de JFLAPS
                    ER                                     JFLAPS
        #############################################################################
        ()                                 #        () (no hay cambios) -> OK
        * (Cierre de Kleene)               #        * (no hay cambios)
        +                                  #          (no existe equivalente directo)
        | (xor)                            #        +
        []                                 #          (no existe equivalente directo)
        ?                                  #          (no existe equivalente directo)
          (no existe equivalente directo)  #        ! (elemento vacío epsilon)


        Transformación con ejemplos:
                    ER                                     JFLAPS
        #############################################################################
        a|b|c                              #        a+b+c
        abc                                #        abc
        a?bc                               #        (!+a)bc
        a+bc                               #        a(!+a)*bc
        (abc)*                             #        (abc)*
        [abcd]                             #        (a+b+c+d)
        [a-z]                              #        (a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z)

     */
    
    public static String getStringRepresentation(ArrayList<Character> list) {
    
        StringBuilder sb = new StringBuilder(list.size());
        for(Character ch : list) {
        
            sb.append(ch);
        
        }
        
        return sb.toString();
    
    }
    
    public static String translate(String inputStr) {
    
        ArrayList<String> operandList = new ArrayList<>();

        for(int i = 0; i < inputStr.length(); i++) {
                        
            if (inputStr.charAt(i) == '(' || inputStr.charAt(i) == '[') {
            
                int j = i + 1;
                boolean isSquared = inputStr.charAt(i) == '[';
                ArrayList<Character> operand = new ArrayList<>();
                while (inputStr.charAt(j) != ')' && inputStr.charAt(j) != ']') {
                
                    operand.add(inputStr.charAt(j));
                    j++;
                
                }
                
                operandList.add(getStringRepresentation(operand));
                if (isSquared) operandList.add("]");
                i = j;
                
            } else {
            
                operandList.add(String.valueOf(inputStr.charAt(i)));
            
            }
            
        }
        
        for(int i = 0; i < operandList.size(); i++) {
        
            String str = operandList.get(i);
            if (str.equals("]")) {
                
                String op = operandList.get(i - 1);
                ArrayList<Character> charList = new ArrayList<>(); 
                charList.add('(');
                for (int j = 0; j < op.length(); j++) {
                
                    charList.add(op.charAt(j));
                    if (j < op.length() - 1) charList.add('+');
                
                }
                charList.add(')');
                operandList.set(i - 1, getStringRepresentation(charList));
                operandList.remove(i);

                
            }
        
        }

        for(int i = 0; i < operandList.size(); i++) {
        
            String str = operandList.get(i);
            if (str.equals("?")) {
                
                String op = operandList.get(i - 1);
                op = op.length() > 1 ? "(!+(" + op + "))" : "(!+" + op + ")";
                operandList.set(i - 1, op);
                operandList.remove(i);

                
            }
        
        }
        
        for(int i = 0; i < operandList.size(); i++) {
        
            String str = operandList.get(i);
            if (str.equals("+")) {
                
                String op = operandList.get(i - 1);
                op = op.length() > 1 ? "(" + op + ")(!+(" + op + "))*" : op + "(!+" + op + ")*";
                operandList.set(i - 1, op);
                operandList.remove(i);

                
            }
        
        }
        
        for(int i = 0; i < operandList.size(); i++) {
        
            String str = operandList.get(i);
            if (str.equals("*")) {
                
                String op = operandList.get(i - 1);
                op = op.length() > 1 ? "(" + op + ")*" : op + "*";
                operandList.set(i - 1, op);
                operandList.remove(i);

                
            }
        
        }
        
        String result = "";
        
        for(String str : operandList) {
        
            result += str;
        
        }
        
        char[] ch = result.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
        
            if (ch[i] == '|') {
            
                ch[i] = '+';
            
            }
        
        }
        
        // Translate + symbol: a+ -> a(!+a)
        
        
        return String.valueOf(ch);
    
    }
    
}
