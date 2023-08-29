/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.pexeso;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Milos
 */
public class Card extends Button {
    private final String name;
    private final ImageView upSide;
    private final ImageView downSide;
    private boolean turn;
    
    public Card(String pSubor, String pName) {
        Image image = new Image("file:images/up_side.jpg");
        this.upSide = new ImageView(image);
         image = new Image("file:images/" + pName + ".png");
        this.downSide = new ImageView(image);
        
        this.upSide.setFitHeight(100);
        this.upSide.setPreserveRatio(true);
        
        this.downSide.setFitHeight(100);
        this.downSide.setPreserveRatio(true);
        
        super.setGraphic(this.upSide);
        super.setPrefSize(100,100);
        
        this.name = pName;
        super.setEffect(new DropShadow());
        this.turn = true;
    }
    
    
    public void showPicture() {
        super.setGraphic(this.downSide);
        super.setPrefSize(100,100);
        this.disableButton();
        
    }
    
    public void showCover() {
        super.setGraphic(this.upSide);
        super.setPrefSize(100,100);
        this.enableButton();
    }
    
    public void enableButton() {
        super.setDisable(false);
        super.setStyle("-fx-opacity: 1");
    }
    
    public void disableButton() {
        super.setDisable(true);
        super.setStyle("-fx-opacity: 1");
    }
    
    
    
    public String name() {
        return this.name;
    }
    
}
