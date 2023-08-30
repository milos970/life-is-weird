/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Milos
 */
public class Area extends GridPane {
    public Area() {
        
         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                    super.add(new ImageView(new Image("file:images/uvod1.png")),i,j);
            }
            }
                
    }
}
