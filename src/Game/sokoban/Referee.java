/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.sokoban;

import java.io.IOException;
import packag.Manager;

/**
 *
 * @author Milos
 */
public final class Referee {
    private final Control c;
    private int points;
    private final PlochaController pc;
    private static int which;
    private int many;
    private static int count = 1;
    
    public Referee(Control c, PlochaController pc) {
        this.c = c;
        this.pc = pc;
        if (which == 0) {
            this.many = 3;
        } else {
            this.many = 7;
        }
        which++;
    }
    
    public void addPoint() throws IOException {
        this.points++;
        if (this.points + 1 == many) {
            if (count == 0) {
                Manager.getInstation(null, null).finishSokoban();
                this.pc.set();
                count--;
                
            } else if (count == 1) {
                
                Manager.getInstation(null, null).nextLevelOfSokoban();
            this.pc.set();
            count--;
            }
                
            
            
        }
    }
    
    public void subPoint() {
        this.points--;
    }
    
    
    
}
