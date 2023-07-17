/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prologue;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import packag.SongPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class Bar implements Initializable {

    
    @FXML
    private ImageView imageView;
    
    
    
    
    @FXML
    private Text dateText;
    @FXML
    private Text quoteTextB;
    @FXML
    private Text quoteTextA;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button drinkButton;
    @FXML
    private TextArea textArea;
    private SongPlayer sp;
    private int h = 1;

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("file:images/black.png");
        this.imageView.setImage(image);
        
        
        
        this.quoteTextA.setVisible(false);
        this.quoteTextB.setVisible(false);
        
        this.imageView.setOpacity(0);
        
        new Timeline(new KeyFrame(
        Duration.millis(3000),
        ae -> {
            this.playSong();
    } ))
        .play();
        
        
        new Timeline(new KeyFrame(
        Duration.millis(8000),
        ae -> {
            this.quoteAppearing();
    } ))
        .play();
        
       
        
        
        new Timeline(new KeyFrame(
        Duration.millis(17000),
        ae -> {
            this.quoteDissapear();
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(20000),
        ae -> {
            this.quoteTextA.setVisible(false);
            this.quoteTextB.setVisible(false);
            this.dateAppearing();
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(20000),
        ae -> {
            this.newImage();
    } ))
        .play();
        
        
        new Timeline(new KeyFrame(
        Duration.millis(23000),
        ae -> {
            this.dateDisapearing();
    } ))
        .play();
        
        new Timeline(new KeyFrame(
        Duration.millis(25000),
        ae -> {
            this.dateText.setVisible(false);
            this.firstDialog();
    } ))
        .play();
           
    }   
    
    
    private void playSong() {
        try {
            this.sp = new SongPlayer();
            this.sp.setLoop(10);
            this.sp.chooseSong(1);
            
            
            
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void quoteAppearing() {
        this.quoteTextA.setVisible(true);
        this.quoteTextB.setVisible(true);
        this.quoteTextA.setText("Veci často niesu také, akými sa zdaju byť.");
        this.quoteTextB.setText("Miloš 19.7.2021");
        
        this.sequention(this.fadeOut(this.quoteTextA,3000),this.fadeOut(this.quoteTextB,3000),1000).play();
        
    }
    
    private void quoteDissapear() {
        this.fadeIn(this.quoteTextA,3000).play();
        this.fadeIn(this.quoteTextB,3000).play();
    }
    
    private void dateAppearing() {
        this.dateText.setVisible(true);
        
        this.dateText.setText("Ｍａｎｈａｔｔａｎ　２０２０");
        
    }
    
    private void dateDisapearing() {
        this.dateText.setVisible(false);
        
    }
      
    private void newImage() {
        Image image = new Image("file:images/uvod1.png");
        this.imageView.setImage(image);
        this.fadeOut(this.imageView, 2000).play();
    }
    
    private void firstDialog() {
        this.textArea.setWrapText(true);    
        this.textArea.setPrefRowCount(10);
        this.textArea.setText("Sedíš vo svojom obľúbenom bare. Je to bar pravidelných tvári, bežných spôsobov balenia a stále rovnakou chuťou vodky.");
        this.textArea.appendText("\nKamarát ťa s nim oboznámil pred 5 rokmi a odvtedy si nenašla dôvod na zmenu, aj keď to tu postupom času prestalo stáť za to.");
        this.drinkButton.setText("Objednáš si drink.");
        this.drinkButton.setVisible(true);
        this.drinkButton.setDisable(true);
        this.h++;
        this.sequention(this.fadeOut(this.textArea, 2000), this.fadeOut(this.drinkButton, 1000),1000).play();   
        new Timeline(new KeyFrame(
        Duration.millis(4000),
        ae -> {
            this.drinkButton.setDisable(false);
    } ))
        .play();
    }
    
    private void secondDialog() {
        
        this.textArea.setText("Prisadne si k tebe chalan s ponukou, že ho zacvaká.");
        
        this.drinkButton.setText("Prijímeš.");
        this.drinkButton.setDisable(true);
        this.sequention(this.fadeOut(this.textArea, 2000), this.fadeOut(this.drinkButton, 1000), 1000).play();
        this.h++;
        new Timeline(new KeyFrame(
        Duration.millis(4000),
        ae -> {
            this.drinkButton.setDisable(false);
    } ))
        .play();
        
    }
  
    
    @FXML
    public void nextPane() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (h == 2) {
            this.secondDialog();
            return;
        }
        this.sp.stop();
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PanelFXML.fxml"));
        this.anchorPane.getChildren().setAll(pane);
    }
    
    private FadeTransition fadeOut(Node node, int millis) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));  
        fadeTransition.setFromValue(0);  
        fadeTransition.setToValue(10);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
    private FadeTransition fadeIn(Node node, int millis) 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));  
        fadeTransition.setFromValue(10);  
        fadeTransition.setToValue(0);  
        fadeTransition.setCycleCount(1);  
        fadeTransition.setNode(node);         
        return fadeTransition;
    }
    
 
    private SequentialTransition sequention(FadeTransition fadeTransitionA, FadeTransition fadeTransitionB,int millis) 
    {
        
        
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(millis));
        SequentialTransition sequentialTransition = new SequentialTransition (fadeTransitionA, pauseTransition, fadeTransitionB);
        return sequentialTransition;
    }
    
    
}
