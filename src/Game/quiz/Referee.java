/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.quiz;

import java.io.IOException;
import packag.Manager;
import Timer.Timer;
/**
 *
 * @author Milos
 */
public final class Referee {
    private final QuizController qc;
    private int number;
    private int points;
    Referee(QuizController qc, int number) {
        this.qc = qc;
        this.number = number + 1;
    }
    
    
    public void next() throws IOException {
        this.number--;
        if (this.number - 1 == -1) {
            this.qc.set();

            Manager.getInstation(null, null).finishQuiz();
        }
    }
    
    public void addPoint() {
        this.points++;
        
        if (points == 5) {
          
            Manager.getInstation(null, null).chec();
        }
    }
    
    public void sub() {
        Timer.getInstantion(0, 0, null).subSeconds(10);
    }
    
    
    
    
    
}
