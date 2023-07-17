/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.sokoban;

import javafx.scene.image.Image;

/**
 *
 * @author Milos
 */
public class Box extends Part {
    
    
    public Box(int x, int y) {
        super(new Image("file:images/box.png"),x,y);
        super.setFitHeight(50);
        super.setPreserveRatio(true);
        
    }
    
    
    public void changeImage() {
        super.setImage(new Image("file:images/box2.png"));
        super.setVisible(true);
    }
    
    public void changeBackImage() {
        super.setImage(new Image("file:images/box.png"));
        super.setVisible(true);

    }
    

    
    
}
