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
import javafx.scene.text.Text;
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
   @FXML
   private Text questionText;
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
        

       
        this.referee = new Referee(this,5);
       try {
           this.setAnswers();
       } catch (IOException ex) {
           Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       
    }

    
    private void setAnswers() throws IOException {
        switch(this.round) {
            
            case 1:
        this.questionText.setText("Low-level programming language");
        this.aButton.setText("C#");
        this.bButton.setText("Java");
        this.cButton.setText("C");
        this.dButton.setText("Python");
        this.round++;
        this.which = 3;
        this.referee.next();
            break;
            case 2:
        this.questionText.setText("Not considered as programming language");
        this.aButton.setText("Python");
        this.bButton.setText("JavaScript");
        this.cButton.setText("Assembler");
        this.dButton.setText("HTML");
        this.round++;
        this.referee.next();
        this.which = 4;
            break;
            case 3:
        this.questionText.setText("");
        this.aButton.setText("Sexy.");
        this.bButton.setText("Tekvička.");
        this.cButton.setText("Kvetinka.");
        this.dButton.setText("Jigglypuff.");

        this.round++;
        this.referee.next();
        this.which = 2;
            break;
            case 4:
        this.aButton.setText("Jaseňová.");
        this.bButton.setText("Limbová.");
        this.cButton.setText("Smreková.");
        this.dButton.setText("Jašeňová.");
        this.which = 3;

        this.round++;
        this.referee.next();
            break;
            case 5:
        this.aButton.setText("2");
        this.bButton.setText("1");
        this.cButton.setText("3");
        this.dButton.setText("4");

        this.referee.next();
        this.which = 1;
            break;
        }
        
    }
    
    
    private void h() throws IOException {
        
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
                    this.h();
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
                    this.h();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }
        

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
                    this.h();
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
                    this.h();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }

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
                    this.h();
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
                    this.h();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
        }

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
                    this.h();
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
                    this.h();
                } catch (IOException ex) {
                    Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }))
    .play();
            this.dButton.setStyle("-fx-background-color: red;");
             this.referee.sub();
        }

    }
    
    public void set() {
        this.pane.setVisible(false);
    }
    
    

}
