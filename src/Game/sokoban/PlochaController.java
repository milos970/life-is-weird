/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.sokoban;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.AudioPlayer;
import packag.Manager;
import packag.main;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class PlochaController extends Application implements Initializable  {

    @FXML
    private Pane pane;
    private Control control;
    @FXML
    private ImageView im;
    private static int which = 1;
    private AudioPlayer ap;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        if (which == 1) {
            this.control = null;
        try {
            Map map = new Map(new Matrix("1.txt"));
            
            this.im.setImage(new Image("file:images/g.jpg"));
            this.pane.getChildren().setAll(this.im);
            this.pane.getChildren().add(map);
            
            this.control = new Control(map,this);
        } catch (IOException ex) {
            Logger.getLogger(PlochaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        } else {
            if (which == 2) {
                try {
            this.ap = new AudioPlayer("easy");
            this.ap.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PlochaController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                new Timeline(new KeyFrame(
        Duration.millis(5000),
        ae -> {
        
    
             Manager.getInstation(null, null).enaf();
            this.control = null;
        try {
            Map map = new Map(new Matrix("2.txt"));
            
            this.im.setImage(new Image("file:images/g.jpg"));
            this.pane.getChildren().setAll(this.im);
            this.pane.getChildren().add(map);
            
            this.control = new Control(map,this);
        } catch (IOException ex) {
            Logger.getLogger(PlochaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
         ))
        .play();
            } else {
            
             
    
             
            this.control = null;
        try {
            Map map = new Map(new Matrix("2.txt"));
            
            this.im.setImage(new Image("file:images/g.jpg"));
            this.pane.getChildren().setAll(this.im);
            this.pane.getChildren().add(map);
            
            this.control = new Control(map,this);
        } catch (IOException ex) {
            Logger.getLogger(PlochaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
         
        
        
        
        
        
}
        }
        which++;
        main.s.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:    control.moveUp(); break;
                case DOWN:  control.moveDown(); break;
                case LEFT:  control.moveLeft(); break;
                case RIGHT: control.moveRight(); break;
                
            }
        });
    }
    
    
  
    
    public void set() {
        this.pane.setVisible(false);
    }
   

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
