/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Timer.Timer;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.Manager;
import packag.SongPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class FrameController implements Initializable {

    private ImageView leftImageView;
    private ImageView centerImageView;
    @FXML
    private Button leftButton;
    @FXML
    private Button centerButton;
    @FXML
    private Button rightButton;
    
    @FXML
    private ImageView background;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane upPane;
    @FXML
    private Pane leftPane;
    @FXML
    private Pane rightPane;

    @FXML
    private Pane timerPane;
   
    
    @FXML
    private Pane pane;
    @FXML
    private Pane slidePane;
    
    @FXML
    private Text digits;
    
    @FXML
    private Pane gamePane;
    private FXMLLoader fxmlLoader;
    @FXML
    private Button againButton;
    private int count;
    private SongPlayer sp;
    @FXML
    private TextField textField;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.textField.setVisible(false);
         Image image = new Image("file:images/background.jpg");
         
        this.background.setImage(image);
        
         image = new Image("file:images/pexeso.PNG");
        ImageView imageView = new ImageView(image);
        this.leftButton.setPrefSize(180, 180);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.leftButton.widthProperty());
        imageView.fitHeightProperty().bind(this.leftButton.heightProperty());
        this.leftButton.setGraphic(imageView);
this.leftButton.setEffect(new DropShadow());
        image = new Image("file:images/sokoban.PNG");
        imageView = new ImageView(image);
        this.centerButton.setPrefSize(180, 180);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.centerButton.widthProperty());
        imageView.fitHeightProperty().bind(this.centerButton.heightProperty());
        this.centerButton.setGraphic(imageView);
        this.centerButton.setEffect(new DropShadow());
        
        image = new Image("file:images/quiz.PNG");
        imageView = new ImageView(image);
        
        this.centerButton.setPrefSize(180, 180);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.rightButton.widthProperty());
        imageView.fitHeightProperty().bind(this.rightButton.heightProperty());
        this.rightButton.setGraphic(imageView);
        this.rightButton.setEffect(new DropShadow());
        /*this.pane.setStyle("-fx-background-color: rgba(255,255,255,253); -fx-background-radius: 10;");
        this.leftPane.setStyle("-fx-background-color: rgba(255,255,255,253); -fx-background-radius: 10;");
        this.upPane.setStyle("-fx-background-color: rgba(240,240,240,240); -fx-background-radius: 10;");
        this.leftButton.setStyle("-fx-background-color: rgba(255,255,255,253); -fx-background-radius: 10;");*/
        
        
         

        

        Manager.getInstation(anchorPane, this);


        //this.disableAll();
        this.enablePexeso();
        Timer.getInstantion(9, 59, digits).run();
        this.againButton.setVisible(false);
    } 
    
    private void disableAll() {
        this.leftButton.setDisable(true);

        this.centerButton.setDisable(true);

        this.rightButton.setDisable(true);
    
}
    
    
    private void enablePexeso() {
        this.leftButton.setDisable(false);
    }
    
    private void enableSokoban() {
        this.centerButton.setDisable(false);
    }
    
    
    private void enableQuiz() {
        this.rightButton.setDisable(false);
    }
    
    
    @FXML
    public void slidePane() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(this.slidePane);
        slide.setToX(560);
        slide.play();
        
        new Timeline(new KeyFrame(
        Duration.millis(1000),
        ae -> {
            this.slidePane.setStyle("-fx-background-radius: 10;");
    } ))
        .play();
        
        
    }
    

    private void nextPane(String path) throws IOException {
        Pane pane = (Pane)this.fxmlLoader.load(getClass().getResource(path + ".fxml"));
        
            

                this.gamePane.getChildren().setAll(pane);
                this.gamePane.setEffect(new DropShadow());
    }
    
    @FXML
    private void again() throws URISyntaxException, IOException {
        this.launchSokoban();
        Timer.getInstantion(0, 0, null).subSeconds(20);
        if (this.count == 2) {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                
                Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Sokoban"));
}
        }
        this.count++;
        
    }
    
   
    
    @FXML
    private void launchPexeso() {
        try {
          
            this.nextPane("/Game/pexeso/Pexeso");
            this.disableAll();
            
        } catch (IOException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void launchSokoban() {
        
        try {
            this.nextPane("/Game/sokoban/Plocha");
            this.centerButton.setDisable(true);
            this.rightButton.setDisable(true);
        } catch (IOException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nextSokoban() throws IOException {
        
        this.nextPane("/Game/sokoban/Plocha");
    }
    
    
    
    
    @FXML
    private void launchQuiz() {
        try {
            this.nextPane("/Game/quiz/Quiz");
            this.rightButton.setDisable(true);
        } catch (IOException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void finishPexeso() {
        this.leftButton.setDisable(true);
        this.leftButton.setStyle("-fx-opacity: 1");
        
        Image image = new Image("file:images/checkedPexeso.PNG");
        ImageView imageView = new ImageView(image);
        this.leftButton.setGraphic(imageView);
        this.leftButton.setVisible(true);
        this.enableSokoban();
        
    }
    
    public void enaC() {
        this.againButton.setVisible(true);
    }
    
    
    public void finishSokoban() {
        this.centerButton.setDisable(true);
        this.centerButton.setStyle("-fx-opacity: 1");
        Image image = new Image("file:images/checkedSokoban.PNG");
        ImageView imageView = new ImageView(image);
        this.centerButton.setGraphic(imageView);
        this.centerButton.setVisible(true);
        this.enableQuiz();
        this.againButton.setVisible(false);

    }

    public void checkedQuiz() {

    }
    
    public void finishQuiz() {
        this.rightButton.setDisable(true);
        this.rightButton.setStyle("-fx-opacity: 1");
        Image image = new Image("file:images/checkedQuiz.PNG");
        ImageView imageView = new ImageView(image);
        this.rightButton.setGraphic(imageView);
        this.rightButton.setVisible(true);

        this.rightButton.setDisable(true);
        
        Timer.getInstantion(0, 0, null).stop();
        
        if (Timer.getInstantion(0, 0, null).getMinutes() == 0 && Timer.getInstantion(0, 0, null).getSeconds() == 0) {

        } else {

        }
        
        new Timeline(new KeyFrame(
        Duration.millis(5000),
        ae -> {
            try {
            this.nextAnchor("/end/Frame");
        } catch (IOException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
    } ))
        .play();
        
        
        
    }
    
    public void nextAnchor(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Pane pane = (Pane)this.fxmlLoader.load(getClass().getResource(path + ".fxml"));
        
            
            this.anchorPane.getChildren().setAll(pane);
    

                
                
    }
    
    
    
    
    
    
}
