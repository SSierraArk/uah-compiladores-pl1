/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ssierra.uah.compiladores.pl1;

import com.ssierra.uah.compiladores.pl1.util.Translator;

/**
 *
 * @author ssierra
 */
public class Main {

    public static void main(String[] args) {

        Translator.translate("Hello world");
        System.out.println(Translator.translate("(abc)+bba*"));


    }
}
