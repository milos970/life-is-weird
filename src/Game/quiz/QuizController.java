/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 * FXML Controller class
 *
 * @author Milos
 */
public class QuizController  implements Initializable  {
   @FXML
   private ImageView imageView;
   @FXML
   private Button reproButton;
   private Repro repro;
   @FXML
   private Button aButton;
   @FXML
   private Button bButton;
   @FXML
   private Button cButton;
   @FXML
   private Button dButton;
   private int round = 1;
   private int which;
   @FXML
   private Pane pane;
   private Referee referee;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.imageView.setImage(new Image("file:images/book.jpg"));
        GaussianBlur blur = new GaussianBlur(10);   
        this.imageView.setEffect(blur);



       try {
           this.repro = new Repro();
           this.reproButton.setGraphic(this.repro);
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
           Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
       }

        this.referee = new Referee(this,5);
       try {
           this.setAnswers();
       } catch (IOException ex) {
           Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
       }


    }
    
    @FXML
    public void playAudio() {

    }
    
    private void nextAudio() {

    }
    
    private void setAnswers() throws IOException {
        switch(this.round) {
            
            case 1:
        
        this.aButton.setText("Wrong");
        this.bButton.setText("Correct");
        this.cButton.setText("Wrong");
        this.dButton.setText("Wrong");
        this.round++;
        this.which = 2;
        this.referee.next();
            break;
            case 2:
        this.aButton.setText("Correct");
        this.bButton.setText("Wrong");
        this.cButton.setText("Wrong");
        this.dButton.setText("Wrong");
        
        this.nextAudio();
        this.round++;
        this.referee.next();
        this.which = 1;
            break;
            case 3:
        
        this.aButton.setText("Wrong");
        this.bButton.setText("Correct");
        this.cButton.setText("Wrong");
        this.dButton.setText("Wrong");
        this.nextAudio();
        this.round++;
        this.referee.next();
        this.which = 2;
            break;
            case 4:
        this.aButton.setText("Wrong");
        this.bButton.setText("Wrong");
        this.cButton.setText("Correct");
        this.dButton.setText("Wrong");
        this.which = 3;
        this.nextAudio();
        this.round++;
        this.referee.next();
            break;
            case 5:
        this.aButton.setText("Correct");
        this.bButton.setText("Wrong");
        this.cButton.setText("Wrong");
        this.dButton.setText("Wrong");
        this.nextAudio();
        this.referee.next();
        this.which = 1;
            break;
        }
        
    }
    
    
    private void initial() throws IOException {

        this.aButton.setStyle("-fx-background-color: transparent;");
        this.bButton.setStyle("-fx-background-color: transparent;");
        this.cButton.setStyle("-fx-background-color: transparent;");
        this.dButton.setStyle("-fx-background-color: transparent;");
        this.setAnswers();

    }
    
    @FXML
    private void buttonA() {
        
        if (this.which == 1) {
            this.referee.addPoint();
            this.aButton.setStyle("-fx-background-color: green;");
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        } else {
            this.aButton.setStyle("-fx-background-color: red;");
            this.referee.sub();
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }
        
        this.repro.stopRecord();
    }
    
    @FXML
    private void buttonB() {
        
        if (this.which == 2) {
            this.referee.addPoint();
            this.bButton.setStyle("-fx-background-color: green;");
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        } else {
            this.bButton.setStyle("-fx-background-color: red;");
             this.referee.sub();
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }
        this.repro.stopRecord();
    }
    
    @FXML
    private void buttonC() {
        this.referee.addPoint();
        if (this.which == 3) {
            this.cButton.setStyle("-fx-background-color: green;");
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
            
        } else {
            this.cButton.setStyle("-fx-background-color: red;");
             this.referee.sub();
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }
        this.repro.stopRecord();
    }
    
    @FXML
    private void buttonD() {
        this.referee.addPoint();
        if (this.which == 4) {
            this.dButton.setStyle("-fx-background-color: green;");
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        } else {
            new Timeline(new KeyFrame(
        Duration.millis(2000),
        ae -> {
                try {
                    this.initial();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
            this.dButton.setStyle("-fx-background-color: red;");
            this.referee.sub();
        }
        this.repro.stopRecord();
    }
    
    public void set() {
        this.pane.setVisible(false);
    }
    
    

}
