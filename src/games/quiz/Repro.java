/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.quiz;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Milos
 */
public class Repro extends ImageView {

    private int index;
    
    
    public Repro() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super.setImage(new Image("file:images/repro.png"));

       
    }
    public void playCurrent() {

    }
    
    public void nextRecord() {
        this.index++;
    }
    
    public void stopRecord() {

    }
    
    
    
}
