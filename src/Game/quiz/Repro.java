/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.quiz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.AudioPlayer;

/**
 *
 * @author Milos
 */
public class Repro extends ImageView {
    private final AudioPlayer[] audioPlayers;
    private int index;
    
    
    public Repro() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super.setImage(new Image("file:images/repro.png"));
        this.audioPlayers = new AudioPlayer[5];
        this.audioPlayers[0] = new AudioPlayer("pisanie");
        this.audioPlayers[1] = new AudioPlayer("foto");
        this.audioPlayers[2] = new AudioPlayer("tekvicka");
        this.audioPlayers[3] = new AudioPlayer("zastavka");
        this.audioPlayers[4] = new AudioPlayer("stretko");
       
    }
    public void playCurrent() {
        try {
            this.audioPlayers[this.index].play();
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(Repro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nextRecord() {
        this.index++;
    }
    
    public void stopRecord() {
        this.audioPlayers[this.index].stop();
    }
    
    
    
}
