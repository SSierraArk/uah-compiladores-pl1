/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssierra.uah.compiladores.pl1.util;

/**
 *
 * @author ssierra
 */
public class MatrixParser {
    
    public static int[][] parseMatrix(String matrixString) {
        String[] rows = matrixString.split(";");
        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] cols = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(cols[j]);
            }
        }

        return matrix;
    }
    
}
