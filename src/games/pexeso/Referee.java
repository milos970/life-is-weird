/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.pexeso;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import main.Manager;
import timer.Timer;

/**
 *
 * @author Milos
 */
public class Referee {
    private int pocet;
    private PexesoController c;
    
    
    public Referee(PexesoController c) {
       
        this.c = c;
        
    }
    
    public void result(Card first, Card second) throws IOException {
         boolean same = first.name().equals(second.name());
         if (!same) {
             Timer.getInstantion(0, 0, null).subSeconds(5);
             
         }
        if (same) {
            
            first.disableButton();
            second.disableButton();
            this.pocet++;
            
            if (this.pocet == 8) {
                this.c.set();
                
                Manager.getInstation(null,null).finishPexeso();
                
            }
            
        } else {
             
            new Timeline(new KeyFrame(
        Duration.millis(500),
        ae -> second.showCover()))
    .play();
            new Timeline(new KeyFrame(
        Duration.millis(500),
        ae -> first.showCover()))
    .play();
           
            
        }
    }
    
   
    
    
    
}
