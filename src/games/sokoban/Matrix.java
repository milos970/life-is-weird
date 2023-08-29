/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Milos
 */
public class Matrix {
    private final char[][] chars;
    
    public Matrix(String cestaKSuboru) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(cestaKSuboru));
        this.chars = new char[9][8];
        for (int i = 0; i < 9; i++) {
            this.chars[i] = br.readLine().toCharArray();
        }
        br.close();  
    }
    
    
    public char character(int indexR, int indexC) {
        return this.chars[indexR][indexC];
    }
    public char[][] character() {
        return this.chars;
    }
    
}
