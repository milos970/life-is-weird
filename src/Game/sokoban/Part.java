/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Milos
 */
public abstract class  Part extends ImageView {
    private int x;
    private int y;
    
    public Part(Image image, int x, int y) {
        super(image);
        this.x = x;
        this.y = y;
    }
    
    
    protected void setX(int value) {
        this.x += value;
    }
    
    protected void setY(int value) {
        this.y += value;
    }
    
    protected int x() {
        return this.x;
    }
    
    protected int y() {
        return this.y;
    }
    
}
