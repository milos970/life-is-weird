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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import main.SongPlayer;

/**
 * FXML Controller class
 *
 * @author Milos
 */
public class PanelFXMLController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextArea textArea;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;



    @FXML
    private ButtonBar buttonBar;
    @FXML
    private Button buttonC;

    private SongPlayer songPlayer;
    @FXML
    private Button buttonD;
    private int h = 1;

    @FXML
    private Text text;
    private int which = 0;
    @FXML
    private Button buttonE;





    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Image image = new Image("file:images/uvod1.png");
        this.imageView.setImage(image);

        try {
            this.songPlayer = new SongPlayer();
            this.songPlayer.setLoop(5);
            this.songPlayer.chooseSong(2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.start(this.h);
        } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
            Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }



    private void start(int which) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException
    {
        if (this.buttonA.isDisabled() || this.buttonB.isDisabled()) {
            return;
        }



        switch(which) {

            case 1:
                this.buttonBar.setVisible(false);
                this.buttonBar.setStyle("-fx-opacity: 1");
                this.buttonA.setStyle("-fx-opacity: 1");
                this.buttonB.setStyle("-fx-opacity: 1");
                this.buttonC.setStyle("-fx-opacity: 1");
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);

                this.textArea.setText("Volá sa Eliot.");
                this.buttonD.setDisable(true);
                this.buttonD.setText("Predstavíš sa mu.");
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonD.setDisable(false);

                        } ))
                        .play();
                this.sequention(this.fadeOut(this.textArea, 2000),this.fadeOut(this.buttonD,1000),1000).play();
                this.h++;
                break;
            case 2:

                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText("Niesi moc zhovorčivá, hlavne ku ľuďom, ktorých poznáš sotva pár minút a tak všetko, čo zo seba dostaneš je úsmev a poďakovanie za drink.");
                this.textArea.appendText("\nEliot to ale nevzdáva a preto navrhne hru.");
                this.textArea.appendText("\n,,Čo povieš, keby dám sériu vecí o sebe a pokiaľ určitú vec máš rovnako alebo aspoň podobne, napijem sa, jo?\"");
                this.buttonD.setText(",,Hmmm, no dobre, skúsme,\"  s úsmevom odpovieš.");
                this.buttonD.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonD.setDisable(false);
                        } ))
                        .play();
                this.buttonBar.setVisible(false);
                this.sequention(this.fadeOut(this.textArea, 2000),this.fadeOut(this.buttonD,1000),1000).play();
                this.h++;
                break;
            case 3:
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();
                this.textArea.setText(",,Začnem teda s niečim easy...som fandom filmovej a v celku aj knižnej série Harry Potter.\"");
                this.setButtons(this.textArea, ",,Milujem ho, ale to väčšina, takže toto boľo fakt easy.",",,Piješ!\"");
                this.h++;
                break;
            case 4:
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText(",,Ok teraz odbočím dosť mimo...pôsobím v IT sektore ako manažér a manažéri...\"");
                this.buttonD.setVisible(false);
                this.buttonBar.setVisible(false);
                this.buttonD.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonD.setDisable(false);
                        } ))
                        .play();
                this.setButton1(this.textArea,",,Majú plno rečí, ale keď príde na kódenie tak sú mimo...viem, som programátorka.\"");
                this.h++;
                break;

            case 5:
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText(",,To nemyslíš vážne, toto je snom každého ITčkára. Navyše mi to pripomenulo istý príbeh.\"");
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.buttonE.setVisible(false);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();

                this.setButtons(this.textArea, ",,Verím, že to je asi šok no...aký?\"",",,Pribeh?\"");
                this.h++;
                break;
            case 6:
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText(",,No, mám rozčítanú jednu knižku a tam sa chalan študujúci IT zoznámil s ITčkárkou docela dosť náhlym spôsobom.\"");
                this.textArea.appendText("\n,,Dokonca boli aj z jednej školy.\"");
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();
                this.setButtons(this.textArea, ",,Zaujimavé, povedz mi voľačo viac o tom.\"", ",,Aha.\"");
                this.h++;
                break;

            case 7:
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText("Hneď aj oľutuješ, že si sa pýtala, lebo Eliota zjavne knižka tak zaujala, až si skoro pozabudla, že niesi nemá.");
                this.textArea.appendText("\nNetrvá ale dlho a pozorne sa započúvaš a naozaj prežívaš ten dej, kedže jeho podanie je naozaj pútavé a navyše sa ti začal javiť dosť sympaticky.");
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();
                this.setButtons(this.textArea, "Neprerušíš ho.", ",,Aha.\"");
                this.h++;
                break;



            case 8:
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText("O chvíľu vás barman upozorní, že sa blíži záverečná.");
                this.textArea.appendText("\nEliot dlho neotála a ponúkne sa, že ťa odprevadí k taxíku.");
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(4000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();
                this.setButtons(this.textArea, "Súhlasíš.", "Odmietneš.");
                this.h++;
                break;
            case 9:
                this.textArea.setVisible(true);
                this.buttonBar.setVisible(false);
                this.buttonD.setVisible(false);
                this.text.setVisible(false);
                if (this.which == 0) {


                    this.textArea.setText("Pred príchodom taxíka ťa ešte stihne požiadať o fb, s čím bez váhania súhlasíš.");



                    this.sequention(this.fadeOut(this.textArea, 3000), this.fadeIn(this.text, 3000), 2000).play();



                    new Timeline(new KeyFrame(
                            Duration.millis(8000),
                            ae -> {
                                this.h++;
                                try {
                                    this.start(this.h);
                                } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                    Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } ))
                            .play();
                    break;
                } else {



                    this.textArea.setVisible(true);
                    this.textArea.setText("Pred rozlúčením mu ale dáš svoj fb.");


                    this.sequention(this.fadeOut(this.textArea, 3000), this.fadeIn(this.textArea, 3000), 2000).play();



                    new Timeline(new KeyFrame(
                            Duration.millis(8000  ),
                            ae -> {
                                this.h++;
                                try {
                                    this.start(this.h);
                                } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                    Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } ))
                            .play();


                    break;
                }
            case 10:
                this.text.setVisible(false);
                this.textArea.setVisible(true);
                this.textArea.setWrapText(true);
                this.textArea.setPrefRowCount(10);
                this.textArea.setText("Ešte tú noc si píšete ako diví, čo ma za následok, že budík ukazuje 3 hodiny ráno.");
                this.textArea.appendText("\nPred zaželaním dobrej noci si ešte stihnete dohodnúť prvé rande.");
                this.textArea.appendText("\nEliot záhadne trvá na parku, s čím napokon súhlasiš.");
                this.textArea.appendText("\nČas už ale nechá čisto na teba.");
                this.buttonBar.setVisible(true);
                this.buttonD.setVisible(false);
                this.buttonBar.setDisable(true);
                new Timeline(new KeyFrame(
                        Duration.millis(5000),
                        ae -> {
                            this.buttonBar.setDisable(false);
                        } ))
                        .play();
                this.setButtons(this.textArea, "V stredu o 4.", "V piatok o 5.");
                this.h++;
                break;


            case 11:
                this.songPlayer.stop();
                this.songPlayer.setLoop(0);
                this.songPlayer.chooseSong(3);
                this.buttonBar.setVisible(false);
                this.fadeIn(this.imageView,3000).play();
                this.fadeIn(this.textArea, 3000).play();
                this.text.setVisible(true);
                new Timeline(new KeyFrame(
                        Duration.millis(14000),
                        ae -> {
                            this.text.setText("Rande číslo 1");
                            this.imageView.setOpacity(0);
                            this.text.setFill(Color.WHITE);

                            this.sequention(this.fadeOut(this.text, 3000), this.fadeIn(this.text, 3000), 2000).play();

                        } ))
                        .play();

                new Timeline(new KeyFrame(
                        Duration.millis(25000),
                        ae -> {
                            Image image = new Image("file:images/park.jpg");
                            try {
                                this.songPlayer.chooseSong(4);
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            this.imageView.setImage(image);
                            GaussianBlur blur = new GaussianBlur(20);
                            this.imageView.setEffect(blur);
                            this.fadeOut(this.imageView, 1000).play();





                        } ))
                        .play();




                new Timeline(new KeyFrame(
                        Duration.millis(27000),
                        ae -> {
                            this.textArea.setOpacity(0);
                            this.textArea.setStyle("-fx-text-fill: white");
                            this.textArea.setStyle("-fx-font-size: 4em;");
                            this.textArea.setText("Keby si tentokrát navrhla ty tú alkoholovú hru, bola by si o chvíľu na mol.");

                            this.fadeOut(this.textArea, 2000).play();



                        } ))
                        .play();








                new Timeline(new KeyFrame(
                        Duration.millis(34000),
                        ae -> {
                            try {
                                this.textArea.setVisible(false);
                                this.songPlayer.stop();
                                this.imageView.setImage(new Image("file:images/black.png"));
                                this.h++;
                                this.start(this.h);
                            } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } ))
                        .play();


                break;
            case 12:
                this.songPlayer.stop();

                this.buttonBar.setVisible(false);


                new Timeline(new KeyFrame(
                        Duration.millis(3000),
                        ae -> {
                            this.text.setText("Rande číslo 2");
                            this.text.setFill(Color.WHITE);


                            this.sequention(this.fadeOut(this.text, 3000), this.fadeIn(this.text, 3000), 2000).play();

                        } ))
                        .play();

                new Timeline(new KeyFrame(
                        Duration.millis(14000),
                        ae -> {

                            this.imageView.setOpacity(0);


                            this.imageView.setImage(new Image("file:images/cinema.jpg"));

                            this.fadeOut(this.imageView, 1000).play();





                        } ))
                        .play();




                new Timeline(new KeyFrame(
                        Duration.millis(18000),
                        ae -> {

                            this.textArea.setOpacity(0);
                            this.textArea.setText("Prvý vášnivý bozk za potlesku, ktorý nepatril ničomu, čo je späté s filmom.");
                            this.textArea.setVisible(true);
                            this.fadeOut(this.textArea, 2000).play();


                        } ))
                        .play();

                new Timeline(new KeyFrame(
                        Duration.millis(19000),
                        ae -> {

                            try {
                                this.songPlayer.chooseSong(5);
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }


                        } ))
                        .play();









                new Timeline(new KeyFrame(
                        Duration.millis(25000),
                        ae -> {
                            try {
                                this.textArea.setVisible(false);
                                this.songPlayer.stop();
                                this.imageView.setImage(new Image("file:images/black.png"));
                                this.h++;
                                this.start(this.h);
                            } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } ))
                        .play();





                break;
            case 13:
                this.songPlayer.stop();

                this.buttonBar.setVisible(false);
                Image image = new Image("file:images/black.png");
                this.imageView.setImage(image);

                new Timeline(new KeyFrame(
                        Duration.millis(3000),
                        ae -> {
                            this.text.setText("Rande číslo 3");
                            this.text.setFill(Color.WHITE);
                            this.text.setVisible(true);

                            this.sequention(this.fadeOut(this.text, 3000), this.fadeIn(this.text, 3000), 2000).play();

                        } ))
                        .play();

                new Timeline(new KeyFrame(
                        Duration.millis(13000),
                        ae -> {


                            this.imageView.setOpacity(0);
                            this.imageView.setImage(new Image("file:images/wine.jpg"));

                            this.fadeOut(this.imageView, 1000).play();





                        } ))
                        .play();




                new Timeline(new KeyFrame(
                        Duration.millis(17000),
                        ae -> {
                            this.textArea.setOpacity(0);

                            this.textArea.setText("Prvé milovanie, v ktorom ale množstvo vína hralo minimálnu rolu.");
                            this.textArea.setVisible(true);
                            this.fadeOut(this.textArea, 2000).play();


                        } ))
                        .play();











                new Timeline(new KeyFrame(
                        Duration.millis(25000),
                        ae -> {
                            try {
                                this.textArea.setVisible(false);
                                this.songPlayer.stop();
                                this.imageView.setImage(new Image("file:images/black.png"));
                                this.h++;
                                this.start(this.h);
                            } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } ))
                        .play();

                break;





            case 14:
                new Timeline(new KeyFrame(
                        Duration.millis(10000),
                        ae -> {
                            this.text.setText("Ubehne sotva rok");
                            this.text.setVisible(true);
                            this.fadeOut(this.text, 1000).play();
                        } ))
                        .play();



                new Timeline(new KeyFrame(
                        Duration.millis(23000),
                        ae -> {
                            try {
                                this.h++;
                                this.start(this.h);
                                this.fadeIn(this.text, 2000).play();

                            } catch (IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } ))
                        .play();
                break;

            case 15:
                this.h++;
                this.start(this.h);



            case 16:

                new Timeline(new KeyFrame(
                        Duration.millis(3000),
                        ae -> {


                            AnchorPane pane = null;
                            try {
                                pane = FXMLLoader.load(getClass().getResource("/flat/Door.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            this.anchorPane.getChildren().setAll(pane);

                        } ))
                        .play();



        }
    }

    private void setButton(TextArea ta, final String pButtonText) {
        this.buttonD.setText(pButtonText);
        this.sequention(this.fadeOut(ta,2000), this.fadeOut(this.buttonD, 1000),1000).play();
    }

    private void setButton1(TextArea ta, final String pButtonText) {
        this.buttonE.setText(pButtonText);
        this.sequention(this.fadeOut(ta,2000), this.fadeOut(this.buttonE, 1000),1000).play();
    }

    private void setButtons(TextArea ta, final String pButtonAText, final String pButtonBText)
    {
        this.buttonA.setText(pButtonAText);
        this.buttonB.setText(pButtonBText);
        this.sequention(this.fadeOut(ta,2000), this.fadeOut(this.buttonBar, 1000),1000).play();
    }



    @FXML
    private void chooseDialogA() throws IOException, InterruptedException {
        this.which = 0;
        try {
            this.start(this.h);
        } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
            Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void chooseDialogB() throws IOException, InterruptedException {
        this.which = 1;
        try {
            this.start(this.h);
        } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
            Logger.getLogger(PanelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }





    private FadeTransition fadeOut(Node pNode, int millis)
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(10.1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setNode(pNode);
        return fadeTransition;
    }

    private FadeTransition fadeIn(Node pNode, int millis)
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(millis));
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setNode(pNode);
        return fadeTransition;
    }

    private SequentialTransition sequention(FadeTransition fadeTransitionA, FadeTransition fadeTransitionB,int millis)
    {
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(millis));
        SequentialTransition sequentialTransition = new SequentialTransition (fadeTransitionA, pauseTransition, fadeTransitionB);
        return sequentialTransition;
    }





}
