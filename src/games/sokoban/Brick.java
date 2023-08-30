/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sokoban;

import javafx.scene.image.Image;

/**
 *
 * @author Milos
 */
public class Brick extends Part {
    
    
    public Brick(int x, int y) {
        
        super(new Image("file:images/brick.jpg"),x,y);
        super.setFitHeight(50);
        super.setPreserveRatio(true);
        
    }
       
    
    
    
   
    
}
