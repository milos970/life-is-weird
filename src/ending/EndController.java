/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ending;

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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import main.AudioPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class EndController implements Initializable {

    
    
    @FXML
    private AnchorPane an;
    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private AudioPlayer au;
    @FXML
    private ImageView imageView;
    @FXML
    private MediaView mediaView1;
    @FXML
    private Pane tele;
    @FXML
    private Pane tv;
    @FXML
    private Pane p;
    @FXML
    private Text end;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.end.setVisible(false);
        this.tv.setVisible(false);
        this.tele.setVisible(false);
        this.p.setVisible(false);
        this.setVideo("ending");



        new Timeline(new KeyFrame(
        Duration.millis(20000),
        ae -> {
            this.fadeIn(this.mediaView, 3000).play();

    } ))
        .play();



         
         new Timeline(new KeyFrame(
        Duration.millis(25000),
        ae -> {
            
                  try {
                      this.au = new AudioPlayer("8");
                      this.au.play();
                      
                
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(EndController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
                  
            
            
            
    } ))
        .play();


         
         new Timeline(new KeyFrame(
        Duration.millis(50000),
        ae -> {
            
                  System.exit(0);
                  
                  
            
            
            
    } ))
        .play();
        
        
        
        
    }
    
    
    private MediaView setVideo(String subor) {
        File f = new File("videos/" + subor + ".mp4");
        Media m = new Media(f.toURI().toString());
        this.mediaPlayer = new MediaPlayer(m);
        
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaView.setPreserveRatio(false);
        this.mediaView.fitWidthProperty().bind(this.an.widthProperty());
        this.mediaView.fitHeightProperty().bind(this.an.heightProperty());
        this.mediaPlayer.play();
        return this.mediaView;
    }
    
    private MediaView stVideo(String subor) {
        File f = new File("videos/" + subor + ".mp4");
        Media m = new Media(f.toURI().toString());
        this.mediaPlayer = new MediaPlayer(m);
        
        this.mediaView1.setMediaPlayer(this.mediaPlayer);
        this.mediaView1.setPreserveRatio(false);
        this.mediaView1.fitWidthProperty().bind(this.tele.widthProperty());
        this.mediaView1.fitHeightProperty().bind(this.tele.heightProperty());
        this.mediaPlayer.play();
        return this.mediaView;
    }
    
    
    private void stopVideo() {
        this.mediaPlayer.stop();
        this.mediaPlayer.dispose();
        
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
