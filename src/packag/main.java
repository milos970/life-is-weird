/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Milos
 */
public class main extends Application {
    public static  Scene s;
    

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
        Scene scene = new Scene (root);
        s = scene;
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:images/icon.png"));
        stage.show();
        
        
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
        
        
        
    }
    
}
