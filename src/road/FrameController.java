/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package road;

import Flat.DoorController;
import Flat.Video;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.AudioPlayer;
import packag.SongPlayer;

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
    
    private MediaPlayer mediaPlayer;
    private MediaPlayer mp;
    @FXML
    private MediaView smartphoneMediaView;
    @FXML
    private ImageView blackImageView;
    private AudioPlayer au;
    private SongPlayer sp ;
    private int a;
    private Video video;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.blackImageView.setVisible(true);
        
        new Timeline(new KeyFrame(
        Duration.millis(5000),
        ae -> {
            try {
            this.sp = new SongPlayer();
            this.sp.setLoop(0);
            this.sp.chooseSong(7);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } ))
        .play();
        
        
      
        
        
        
        new Timeline(new KeyFrame(
        Duration.millis(7000),
        ae -> {
            try {
                this.sp.chooseSong(8);
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
        
        
        
        new Timeline(new KeyFrame(
        Duration.millis(10000),
        ae -> {
            try {
                this.start(1);
            } catch (IOException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
        
        
        
        
        
            
           
       
        
        
        
        
        
        
        
        
        
        
        
    } 
    
    
    
    private void start (final int which) throws IOException {
        String video;
        switch(which) {
            case 1:
                
                this.fadeOut(this.setVideo("road1"), 2000).play();
                
            new Timeline(new KeyFrame(
        Duration.millis(8000),
        ae -> {
            try {
                AudioPlayer au = new AudioPlayer("10");
                au.play();
                
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
            
        new Timeline(new KeyFrame(
        Duration.millis(10000),
        ae -> {
            this.setVideoOnSmartphone("messages1");
            
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(135000),
        ae -> {
            this.stopVideoOnSmartphone();
            
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(137000),
        ae -> {
            this.setVideoOnSmartphone("messages2");
            
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(171000),
        ae -> {
            this.stopVideoOnSmartphone();
            
    } ))
        .play();
        
        
        new Timeline(new KeyFrame(
        Duration.millis(175000),
        ae -> {
            this.fadeIn(this.mediaView, 3000).play();
            
    } ))
        .play();
        
                new Timeline(new KeyFrame(
        Duration.millis(179000),
        ae -> {
            this.stopVideo();
            
    } ))
        .play();
           
        
        
                
                
                
                new Timeline(new KeyFrame(
        Duration.millis(185000),
        ae -> {
            
            try {
                this.videoOrder(1);
            } catch (IOException ex) {
                Logger.getLogger(Flat.FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
        
    
    
    new Timeline(new KeyFrame(
        Duration.millis(257000),
        ae -> {
            
            try {
                this.videoOrder(2);
            } catch (IOException ex) {
                Logger.getLogger(Flat.FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    } ))
        .play();
                
                break;
           
                
                
            
                
                
        }
    }
    
    private void videoOrder(int which) throws IOException {
        
        switch(which) {
            case 1:
                try {
            AudioPlayer audioPlayer = new AudioPlayer("door_opening");
            audioPlayer.play();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(DoorController.class.getName()).log(Level.SEVERE, null, ex);
        }
                new Timeline(new KeyFrame(
        Duration.millis(15000),
        ae -> {
            
        this.video = new Video("flat");
                this.video.play();
                this.anchorPane.getChildren().add(video);
                this.fadeOut(video, 1000);
                
                new Timeline(new KeyFrame(
        Duration.millis(38000),
        e -> {
            
        AudioPlayer ap;
            try {
                ap = new AudioPlayer("10");
                        ap.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Flat.FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
    } ))
        .play();

            
    } ))
        .play();
                
        
    
                
               
                
                break;
            case 2:
                Pane pane = FXMLLoader.load(getClass().getResource("/packag/MonitorFXML.fxml"));
        this.anchorPane.getChildren().setAll(pane);
                break;
        }
    }
    
    
    private MediaView setVideo(String subor) {
        File f = new File("videos/" + subor + ".mp4");
        Media m = new Media(f.toURI().toString());
        this.mediaPlayer = new MediaPlayer(m);
        
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaView.setPreserveRatio(false);
        this.mediaView.fitWidthProperty().bind(this.anchorPane.widthProperty());
        this.mediaView.fitHeightProperty().bind(this.anchorPane.heightProperty());
        this.mediaPlayer.play();
        return this.mediaView;
    }
    
    private void volume(double value) {
        this.mediaPlayer.setVolume(value);
    }
    
    private void stopVideo() {
        this.mediaPlayer.stop();
        this.mediaPlayer.dispose();
        
    }
    
    private void setVideoOnSmartphone(String subor) {
        File f = new File("videos/" + subor + ".mp4");
        Media m = new Media(f.toURI().toString());
        this.mp = new MediaPlayer(m);
        
        this.smartphoneMediaView.setMediaPlayer(this.mp);
        this.smartphoneMediaView.setPreserveRatio(true);
        this.smartphoneMediaView.setVisible(true);
        
        this.mp.play();
    }
    
    
    
    private void stopVideoOnSmartphone() {
        this.mp.stop();
        this.mp.dispose();
        
        
        this.smartphoneMediaView.setVisible(false);
        this.mediaView.setVisible(true);
        
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
    
}
