/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packag;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Milos
 */
public final class AudioPlayer {
    private final Clip clip;
    
    public AudioPlayer(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this(file,1);
    }
    public AudioPlayer(String file, int numberOfLoops) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File f = new File("audio/"+ file + ".wav");
        AudioInputStream audio = AudioSystem.getAudioInputStream(f);
        this.clip = AudioSystem.getClip();
        this.clip.open(audio);
        this.clip.loop(numberOfLoops);
        this.clip.stop();
    }

    
    public void play() throws LineUnavailableException, IOException {
        this.clip.setFramePosition(0);
        this.clip.start();   
        
    }
    
    public void stop() {
        this.clip.stop();  
    }
  
    
}
    

