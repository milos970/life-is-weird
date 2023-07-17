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
public class SongPlayer {
    private AudioInputStream audio; 
    private Clip clip;
    private int loop;
    
    public SongPlayer() throws UnsupportedAudioFileException, IOException {
        
    }
    
    private void play() throws LineUnavailableException, IOException {
            this.clip = AudioSystem.getClip();
            this.clip.open(this.audio);
            this.clip.start();
            this.clip.loop(this.loop);  
            
            
    }
    
    public void setLoop(int loop) {
        this.loop = loop;
    }
    
   
    
    public void stop() {
        this.clip.stop();  
    }
    
    public void chooseSong(int which) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File f = new File("audio/"+ which + ".wav");
        this.audio = AudioSystem.getAudioInputStream(f);
        this.play();
    }
    
}
