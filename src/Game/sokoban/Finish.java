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
public class Finish extends Part {
    
    public Finish(int x, int y) {
        super(new Image("file:images/finish.png"),x,y);
        super.setFitHeight(50);
        super.setPreserveRatio(true);
    }
    
}
