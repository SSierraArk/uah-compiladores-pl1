/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssierra.uah.compiladores.pl1.util;

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
    
    public static String translate(String inputStr) {
    
        // To be modified.
        // Translate + symbol: a+ -> a(!+a)
        
        
        return new String();
    
    }
    
}
