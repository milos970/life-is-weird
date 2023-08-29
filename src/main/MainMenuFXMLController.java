/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Milos
 */
public class MainMenuFXMLController implements Initializable 
{

    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane an;
    @FXML
    private Button button;
    
    private MediaPlayer mediaPlayer;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.mediaView.setOpacity(0);
        File f = new File("videos/menu.mp4");
        Media m = new Media(f.toURI().toString());
        this.mediaPlayer = new MediaPlayer(m);
        
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaView.setPreserveRatio(false);
        this.mediaView.fitWidthProperty().bind(this.an.widthProperty());
        this.mediaView.fitHeightProperty().bind(this.an.heightProperty());

        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.play();

        
        this.sequention(this.fadeOut(this.mediaView), this.fadeOut(this.button),3000).play();
        this.button.setDisable(true);
        new Timeline(new KeyFrame(
        Duration.millis(10000),
        ae -> this.k()))
    .play();
       
    }  
    
    private FadeTransition fadeOut(Node node) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(5000));  
        fadeTransition.setFromValue(0);  
        fadeTransition.setToValue(10);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
    private FadeTransition fadeIn(Node node) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(5000));  
        fadeTransition.setFromValue(10);  
        fadeTransition.setToValue(0);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
    @FXML
    private void nextPane() 
    {   this.button.setVisible(false);
        this.sequention(this.fadeIn(this.mediaView), this.fadeIn(this.button),3000).play();
        new Timeline(new KeyFrame(
        Duration.millis(5000),
        ae -> {
        try {
            this.methods();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } ))
        .play();
      
    }
    
    private void methods() throws IOException {
        this.mediaPlayer.stop();
        this.mediaPlayer.dispose();
        Pane pane = FXMLLoader.load(getClass().getResource("/flat/Door.fxml"));
        this.an.getChildren().setAll(pane);
        
        
    }
    
    private void k() {
        this.button.setDisable(false);
    }
    
    
    private SequentialTransition sequention(FadeTransition fadeTransitionA, FadeTransition fadeTransitionB, int millis) 
    {
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(millis));
        SequentialTransition sequentialTransition = new SequentialTransition (fadeTransitionA, pauseTransition, fadeTransitionB);
        return sequentialTransition;
    }

    
    
    
    
}
    
