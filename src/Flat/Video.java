/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flat;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Milos
 */
public class Video extends MediaView {
    private final MediaPlayer mediaPlayer;
    private final String nazov;
    
    public Video(String nazov) {
        File f = new File("videos/" + nazov + ".mp4");
        Media m = new Media(f.toURI().toString());
        this.mediaPlayer = new MediaPlayer(m);
        
        super.setMediaPlayer(this.mediaPlayer);
        super.setPreserveRatio(false);
        super.setLayoutX(0);
        super.setLayoutY(0);
        super.setFitHeight(660);
        super.setFitWidth(1200);
        this.mediaPlayer.stop();
        this.nazov = nazov;
    }
    
    public void play() {
        this.mediaPlayer.play();
    }
    
    public void stop() {
        this.mediaPlayer.stop();
    }
    
    public String nazov() {
        return this.nazov;
    }
    
}
