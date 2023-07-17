/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import login.FrameController;

/**
 *
 * @author Milos
 */
public class Manager {
    private static Manager instantion ;
    private final AnchorPane an;
    private FXMLLoader  loginLoader;
    private final FrameController fc;
   
    private Manager(AnchorPane an, FrameController fc) {
        this.an = an;
        this.fc = fc;
    }
    
    public static Manager getInstation(AnchorPane an,FrameController fc) {
        if (instantion == null) {
            instantion = new Manager(an,fc);
        }
        return instantion;
    }
    
    public void nextLevelOfSokoban() {
        try {
            this.fc.nextSokoban();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void finishPexeso() {
        
        this.fc.finishPexeso();
    }
    
    public void enaf() {
        this.fc.enaC();
    }
    
    
    public void finishSokoban() throws IOException {
        
            this.fc.finishSokoban();
        
        
    }
    
    public void finishQuiz() throws IOException {

            this.fc.finishQuiz();
        
        
    }

    public void chec() {
        this.fc.checkedQuiz();
    }
    
    public void next() throws IOException {
        try {
            this.fc.nextAnchor("/end/Frame");
        } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
