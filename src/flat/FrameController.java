/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flat;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import main.AudioPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class FrameController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MediaView mediaView;
    
    private Video video;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        new Timeline(new KeyFrame(
        Duration.millis(15000),
        ae -> {
            
            try {
                this.videoOrder(1);
            } catch (IOException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
        
    
    
    new Timeline(new KeyFrame(
        Duration.millis(73000),
        ae -> {
            
            try {
                this.videoOrder(2);
            } catch (IOException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
        
    }
    
    private void videoOrder(int which) throws IOException {
        switch(which) {
            case 1:
                this.video = new Video("flat");
                this.video.play();
                this.anchorPane.getChildren().add(video);
                this.fadeOut(video, 1000);
                
                new Timeline(new KeyFrame(
        Duration.millis(35000),
        ae -> {
            
        AudioPlayer ap;
            try {
                ap = new AudioPlayer("6");
                        ap.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
    } ))
        .play();
        
    
                
               
                
                break;
            case 2:
                Pane pane = FXMLLoader.load(getClass().getResource("/main/MonitorFXML.fxml"));
        this.anchorPane.getChildren().setAll(pane);
                break;
        }
    }
    
    
    
    
    
   
        
        
    
    
    
    
    
    
    
    
    private FadeTransition fadeOut(Node node, int millis) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));  
        fadeTransition.setFromValue(0);  
        fadeTransition.setToValue(10);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
    private FadeTransition fadeIn(Node node, int millis) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));  
        fadeTransition.setFromValue(10);  
        fadeTransition.setToValue(0);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
    
    private SequentialTransition sequention(FadeTransition fadeTransitionA, FadeTransition fadeTransitionB,int millis) 
    {
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(millis));
        SequentialTransition sequentialTransition = new SequentialTransition (fadeTransitionA, pauseTransition, fadeTransitionB);
        return sequentialTransition;
    }
    
}
