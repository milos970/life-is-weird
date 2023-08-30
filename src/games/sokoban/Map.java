/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sokoban;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
/**
 *
 * @author Milos
 */
public class Map extends GridPane {
    private final Matrix matrix;
    private final Part[][] imageViews; 
    private  Character character;
    private final int[][] number;
   
    
    public Map(Matrix matrix) {
        int count = 0;
        this.matrix = matrix;
        
        this.imageViews = new Part[9][8];
        this.number = new int[9][8];
           
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                
                
                switch(matrix.character(i, j)) {
                    case 'X':
                        
                        super.add(new Brick(i,j), j, i);
                        break;
                    case 'S':
                        this.character = new Character(i,j);
                        
                        
                        super.add(this.character, j, i);
                        break;
                    case 'B':
                        
                        super.add(new Box(i,j), j, i);
                        break;
                    case 'F':
                        
                        super.add(new Finish(i,j), j, i);
                        this.number[i][j] = 1;
                        break;
                    case '.':
                        
                        
                        break;
                    
                }
                
            }
            
        }
        
    }
    
    public void add(Part v, int y, int x) {
        super.getChildren().remove(v);
        super.add(v,y,x);
    }
    
    public Character character() {
        return this.character;
    }
    public int[][] getArray() {
        return this.number;
    }
    
    
    
    public Matrix matrix() {
        return this.matrix;
    }
    
    public Node getNodeFromGridPane(int col, int row) {
        
    for (Node node : this.getChildren()) {
        
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            if (node instanceof Finish || node instanceof Area) {
                continue;
            }
            return node;
        }
    }
    return null;
}
    
    
    
    public ImageView[][] array() {
        return this.imageViews;
    }
    
}
