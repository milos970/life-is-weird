/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.pexeso;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class PexesoController extends Application implements Initializable  {
    @FXML
    private ImageView image_view;
    
    @FXML
    private Pane pane;
   
    private  ArrayList<Card> cards;
    
    @FXML
    private GridPane gridPane;
    
    private Card clickedCard;
    
    
    private Referee referee;
    
    
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        this.startUp();
        
        this.showCover();
    
        
        
        
    
    }
    
    
    
    private void startUp() {
        Image image = new Image("file:images/wood.jpg");
       
        this.image_view.setImage(image);
        
        this.cards = new ArrayList<>();
        
        this.initializeCards();
        this.setAction();
        this.randomSort();
        this.addToGridPane();
        this.showCover();
        
        
        
        
        this.referee = new Referee(this);
        
        
    }
    
    private void showPictures() {
        for (Object o: this.cards) {
            Card c = (Card) o;
            c.showPicture();
        }
    }
    
    
     private void showCover() {
        for (Object o: this.cards) {
            Card c = (Card) o;
            c.showCover();
        }
    }
    
    private void again() {
       
        new Timeline(new KeyFrame(
        Duration.millis(5000),
        ae -> this.remove()))
    .play();
        
        
        this.startUp();
    }
    
    private void remove() {
        ObservableList<Node> list = this.gridPane.getChildren();
        for (Object o: list) {
            list.remove(o);
        }
    }
    
    private void initializeCards() {
        this.cards.add(new Card("java", "java"));
        this.cards.add(new Card("java", "java"));
        this.cards.add(new Card("swift", "swift"));
        this.cards.add(new Card("swift", "swift"));
        this.cards.add(new Card("cpp", "cpp"));
        this.cards.add(new Card("cpp", "cpp"));
        this.cards.add(new Card("html", "html"));
        this.cards.add(new Card("html", "html"));
        this.cards.add(new Card(".net", ".net"));
        this.cards.add(new Card(".net", ".net"));
        this.cards.add(new Card("js", "js"));
        this.cards.add(new Card("js", "js"));
        this.cards.add(new Card("python", "python"));
        this.cards.add(new Card("python", "python"));
        this.cards.add(new Card("ms", "ms"));
        this.cards.add(new Card("ms", "ms"));
    }
    
    private void setAction() {
        for(Object element : this.cards) {
            Card card = (Card)element;
            card.setOnAction(event -> {
            card.showPicture();
                try {
                    this.testing(card);
                } catch (IOException ex) {
                    Logger.getLogger(PexesoController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        }
    }
    
    private void randomSort() {
        Collections.shuffle(this.cards);
    }
    
    private void addToGridPane() {
        int index = 0;
        for (int i = 0; i <= 3; i++ ) {
            for (int j = 0; j <= 3; j++) {
                this.gridPane.add(this.cards.get(index++),i,j);
            }
        }
        

    }
    
    
    private void testing(Card card) throws IOException {
        
        if (this.clickedCard == null) {
            this.clickedCard = card;
           
            return;
        }
        
        
        
        this.referee.result(this.clickedCard, card);
        this.clickedCard = null;
    }
    
    @FXML
    private void backToTheMenu() {
        Pane pane = null;
        try {
            pane = (Pane)FXMLLoader.load(getClass().getResource("/login/Frame.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(PexesoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pane.getChildren().setAll(pane);
    }
    
    
    
    

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void set() {
        
        this.pane.setVisible(false);
    }
    
    
    
}
