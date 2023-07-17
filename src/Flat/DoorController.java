/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.AudioPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class DoorController implements Initializable {

    @FXML
    private Button handleButton;
    @FXML
    private ImageView backgroundImageView;
    
    private AudioPlayer audioPlayer;
    @FXML
    private AnchorPane an;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("file:images/door.jpg");
        
        
        this.backgroundImageView.setImage(image);
        
        image = new Image("file:images/handle.png");
        ImageView imageView = new ImageView(image);
        this.handleButton.setPrefSize(64, 26);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.handleButton.widthProperty());
        imageView.fitHeightProperty().bind(this.handleButton.heightProperty());
        this.handleButton.setGraphic(imageView);
        
        try {
            this.audioPlayer = new AudioPlayer("door_opening");
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(DoorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    public void s() throws IOException, LineUnavailableException 
    {   this.audioPlayer.play();
        Image image = new Image("file:images/black.PNG");
        this.backgroundImageView.setImage(image);
        this.handleButton.setVisible(false);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Frame.fxml"));
        new Timeline(new KeyFrame(
        Duration.millis(15000),
        ae -> {
            
        this.an.getChildren().setAll(pane);
            
    } ))
        .play();
    }
    
    
}
