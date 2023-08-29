/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import main.Manager;
import main.SongPlayer;

/**
 *
 * @author Milos
 */
public class Timer {
    private int minutes;
    private int seconds;
    private Text text;
    private static Timer instantion;
    private boolean stop = false;
    
    private Timer(int minutes, int seconds, Text text) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.text = text;
    }
    
    public static Timer getInstantion(int minutes, int seconds, Text text) {
        if (instantion == null) {
            instantion = new Timer(minutes, seconds, text);
        }
        return instantion;
    }
    
    public void run() {
        if (this.seconds < 0 && minutes - 1 != - 1) {
            this.minutes--;
            this.seconds = 60 + this.seconds;
        }
        
        new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> {
            
            if (stop) {
                return;
            }
            
            if (this.minutes == -1) {
                try {
                    Manager.getInstation(null, null).next();
                    SongPlayer sp = new SongPlayer();
                    sp.chooseSong(11);
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            this.seconds--;
            if (this.seconds <= 9) {
                this.text.setText(String.valueOf("0" + this.minutes + ":" + "0" + this.seconds));
            } else {
                this.text.setText(String.valueOf("0" + this.minutes + ":" + this.seconds));
            }
            
            if ((this.seconds - 1) == -1) {
                this.minutes--;
                this.seconds = 60;
            }
            
            this.run();
    } ))
        .play();
    }
    
    
    public void subSeconds(int number) {
        this.seconds -= number;
    }
    
    public void stop() {
        this.stop = true;
    }
    
    public int getSeconds() {
        return this.seconds;
    }
    
    public int getMinutes() {
        return this.minutes;
    }
    
}
