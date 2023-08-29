/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packag;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import login.FrameController;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class MonitorFXMLController implements Initializable {

    @FXML
    private ImageView imageView;
    
    
    
    @FXML
    private Button button;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView displayImageView;
    @FXML
    private ImageView ipadImageView;
    @FXML
    private ImageView screenImageView;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Circle circleA;
    @FXML
    private Circle circleB;
    @FXML
    private Circle circleC;
    @FXML
    private Circle circleD;
    private final String password = "1650";
    private String guessedPassword = "";
    
    @FXML
    Text prompt;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image = new Image("file:images/marble.PNG");
        this.imageView.setImage(image);
        
        image = new Image("file:images/ipad.png");
        this.ipadImageView.setImage(image);
        this.ipadImageView.setEffect(new DropShadow());
        
        this.ipadImageView.setPreserveRatio(true);
        
        this.ipadImageView.setImage(image);
        
        
        image = new Image("file:images/wallpaper.jpg");
        this.displayImageView.setImage(image);
        GaussianBlur blur = new GaussianBlur(20);    
        this.displayImageView.setEffect(blur);
        
        this.prompt.setOpacity(50);
        this.prompt.setText("Pin: 1650");
        this.prompt.setFill(Color.WHITE);
        
        this.setCirclesTransparent();
        
        
        
        
    }    
    
    

    
    private void nextPane() throws IOException 
    {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/Frame.fxml"));
        Pane p = (Pane)loader.load();
        
        FrameController fc = loader.<FrameController>getController();
        if (fc == null) {

        }
        
        
        this.anchorPane.getChildren().setAll(p);
        Manager.getInstation(this.anchorPane,fc);
        
    }
    
    
    
    private void setCirclesWhite() {
        if (this.circleA.getFill() !=  Color.WHITE) {
            this.circleA.setFill(Color.WHITE);
            
            return;
        }
        
        if (this.circleB.getFill() !=  Color.WHITE) {
            this.circleB.setFill(Color.WHITE);
            
            return;
        }
        
        if (this.circleC.getFill() !=  Color.WHITE) {
            this.circleC.setFill(Color.WHITE);
            
            return;
        }
        
        if (this.circleD.getFill() !=  Color.WHITE) {
            this.circleD.setFill(Color.WHITE);
            
            return;
        }
    }
    
    private void setCirclesTransparent()  {
        this.circleA.setFill(Color.TRANSPARENT);
        this.circleB.setFill(Color.TRANSPARENT);
        this.circleC.setFill(Color.TRANSPARENT);
        this.circleD.setFill(Color.TRANSPARENT);
    }
    

    @FXML
    public void handle(ActionEvent e) {
       Button b = (Button) e.getTarget();
       
       if (b == this.button1) {
           this.guessedPassword += 1;
        
       }
       
       if (b == this.button2) {
           this.guessedPassword += 2;
           
       }
       
       if (b == this.button3) {
           this.guessedPassword += 3;
       }
       
       if (b == this.button4) {
           this.guessedPassword += 4;
       }
       
       if (b == this.button5) {
           this.guessedPassword += 5;
       }
       
       if (b == this.button6) {
           this.guessedPassword += 6;
       }
       
       if (b == this.button7) {
           this.guessedPassword += 7;
       }
       
       if (b == this.button8) {
           this.guessedPassword += 8;
       }
       
       if (b == this.button9) {
           this.guessedPassword += 9;
       }
       
       if (b == this.button0) {
           this.guessedPassword += 0;
       }
       
       this.setCirclesWhite();
       
       
       if (this.guessedPassword.length() == 4) {
           
           if (this.guessedPassword.equals(this.password)) {
               
               try {
                   this.nextPane();
               } catch (IOException ex) {
                   Logger.getLogger(MonitorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } else {
               this.setCirclesTransparent();
               this.guessedPassword = "";
           }
       }
    }

    
}
