package Game.sokoban;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Control  {
    private final Map map;
    private final Character character;
    private final Referee referee;
    
    
    public Control(Map map, PlochaController pc) {
        this.map = map;
        this.character = this.map.character();
        this.referee = new Referee(this, pc);
        
    }
    
    

    public void moveUp() {
        if (this.map.matrix().character(this.character.y() - 1, this.character.x()) == 'B') {
             if (this.map.matrix().character(this.character.y() - 2, this.character.x()) == 'B' || this.map.matrix().character(this.character.y() - 2, this.character.x()) == 'X') {
             } else {
                 char[][] l = this.map.matrix().character();
                 
                 //ak je box na finishi tak pohni dopredu a posun figurku na finish
                 int[][]a = this.map.getArray();
                 
                 if (a[this.character.y()-2][this.character.x()] == 1) {
                     
                     l[this.character.y()-2][this.character.x() ] = 'B';
                     l[this.character.y() - 1][this.character.x() ] = '.';
                                          
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() - 1);
                     
                     this.character.setY(-1);
                     this.map.add(box,this.character.x(), this.character.y() - 1);
                     box.changeImage();
                     try {
                         this.referee.addPoint();
                     } catch (IOException ex) {
                         Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     this.map.add(this.character, this.character.x(), this.character.y());
                     return;
                 }
                 
                 
                 if (a[this.character.y() - 1][this.character.x()] == 1) {
                    
                     l[this.character.y() - 1][this.character.x() ] = 'F';
                     l[this.character.y()-2][this.character.x() ] = 'B';
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() - 1);
                     
                     this.map.add(box,this.character.x(), this.character.y() - 2);
                     box.changeBackImage();
                     this.referee.subPoint();
                     this.character.setY(-1);
                     this.map.add(this.character,this.character.x(), this.character.y());
                     
                     return;
                     
                 } 
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() - 1);
                     
                 this.map.add(box, this.character.x() , this.character.y() - 2);
                 this.character.setY(-1);
                 l[this.character.y()][this.character.x()] = '.';
                 l[this.character.y() - 1][this.character.x()] = 'B';
                 this.map.add(this.character, this.character.x(), this.character.y());
             }
             
             
            
         } else {
        if (this.map.matrix().character(this.character.y() - 1, this.character.x()) != 'X') {
        this.character.setY(-1);
        this.map.add(this.character, this.character.x(), this.character.y());
    }
    }
    }
    
    
    public void moveDown() {
        if (this.map.matrix().character(this.character.y() + 1, this.character.x()) == 'B') {
             if (this.map.matrix().character(this.character.y() + 2, this.character.x()) == 'B' || this.map.matrix().character(this.character.y() + 2, this.character.x()) == 'X') {
             } else {
                 char[][] l = this.map.matrix().character();
                 
                 //ak je box na finishi tak pohni dopredu a posun figurku na finish
                 int[][]a = this.map.getArray();
                 if (a[this.character.y()+2][this.character.x()] == 1) {
                     
                     l[this.character.y()+2][this.character.x() ] = 'B';
                     l[this.character.y() + 1][this.character.x() ] = '.';
                                          
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() + 1);
                     this.character.setY(1);
                     this.map.add(box,this.character.x(), this.character.y() + 1);
                     box.changeImage();
                     try {
                         this.referee.addPoint();
                     } catch (IOException ex) {
                         Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     this.map.add(this.character, this.character.x(), this.character.y());
                     return;
                 }
                 
                 
                 if (a[this.character.y() + 1][this.character.x()] == 1) {
                     
                     l[this.character.y() + 1][this.character.x() ] = 'F';
                     l[this.character.y()+2][this.character.x() ] = 'B';
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() + 1);
                     this.map.add(box,this.character.x(), this.character.y() + 2);
                     box.changeBackImage();
                     this.referee.subPoint();
                     this.character.setY(1);
                     this.map.add(this.character,this.character.x(), this.character.y());
                     
                     return;
                     
                 } 
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x(), this.character.y() + 1);
                 this.map.add(box, this.character.x() , this.character.y()+ 2);
                 this.character.setY(1);
                 l[this.character.y()][this.character.x()] = '.';
                 l[this.character.y() + 1][this.character.x()] = 'B';
                 this.map.add(this.character, this.character.x(), this.character.y());
             }
             
            
         } else {
        if (this.map.matrix().character(this.character.y() + 1, this.character.x()) != 'X') {
        this.character.setY(1);
        this.map.add(this.character, this.character.x(), this.character.y());
    }
    }
    }

    
    public void moveRight() {
         if (this.map.matrix().character(this.character.y(), this.character.x() + 1) == 'B') {
             if (this.map.matrix().character(this.character.y(), this.character.x() + 2) == 'B' || this.map.matrix().character(this.character.y(), this.character.x() + 2) == 'X') {
             } else {
                 char[][] l = this.map.matrix().character();
                 
                 //ak je box na finishi tak pohni dopredu a posun figurku na finish
                 int[][]a = this.map.getArray();
                 if (a[this.character.y()][this.character.x() + 2] == 1) {
                     
                     l[this.character.y()][this.character.x() + 2 ] = 'B';
                     l[this.character.y()][this.character.x() + 1] = '.';
                                          
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() + 1, this.character.y());
                     
                     this.character.setX(1);
                     
                     this.map.add(box,this.character.x() + 1, this.character.y());
                     box.changeImage();
                     try {
                         this.referee.addPoint();
                     } catch (IOException ex) {
                         Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     this.map.add(this.character, this.character.x(), this.character.y());
                     return;
                 }
                 
                 
                 if (a[this.character.y()][this.character.x() + 1] == 1) {
                     
                     l[this.character.y()][this.character.x() + 1 ] = 'F';
                     l[this.character.y()][this.character.x() + 2 ] = 'B';
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() + 1, this.character.y());
                     this.map.add(box,this.character.x() + 2, this.character.y());
                     box.changeBackImage();
                     this.referee.subPoint();
                     this.character.setX(1);
                     this.map.add(this.character,this.character.x(), this.character.y());
                     
                     return;
                     
                 } 
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() + 1, this.character.y());
                 this.map.add(box, this.character.x() + 2, this.character.y());
                 this.character.setX(1);
                 l[this.character.y()][this.character.x()] = '.';
                 l[this.character.y()][this.character.x() + 1] = 'B';
                 
                 this.map.add(this.character, this.character.x(), this.character.y());
             }
             
            
         } else {
        if (this.map.matrix().character(this.character.y(), this.character.x() + 1) != 'X') {
        this.character.setX(1);
        this.map.add(this.character, this.character.x(), this.character.y());
    }
    }
    }
    
    public void moveLeft() {
        
         if (this.map.matrix().character(this.character.y(), this.character.x() - 1) == 'B') {
             if (this.map.matrix().character(this.character.y(), this.character.x() - 2) == 'B' || this.map.matrix().character(this.character.y(), this.character.x() - 2) == 'X') {
             } else {
                 char[][] l = this.map.matrix().character();
                 
                 //ak je box na finishi tak pohni dopredu a posun figurku na finish
                 int[][]a = this.map.getArray();
                 if (a[this.character.y()][this.character.x() - 2] == 1) {
                     
                     l[this.character.y()][this.character.x() - 2 ] = 'B';
                     l[this.character.y()][this.character.x() - 1] = '.';
                                          
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() - 1, this.character.y());
                     this.character.setX(-1);
                     
                     this.map.add(box,this.character.x() - 1, this.character.y());
                     box.changeImage();
                     try {
                                    this.referee.addPoint();
                     } catch (IOException ex) {
                         Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     this.map.add(this.character, this.character.x(), this.character.y());
                     return;
                 }
                 
                 
                 if (a[this.character.y()][this.character.x() - 1] == 1) {
                     
                     l[this.character.y()][this.character.x() - 1 ] = 'F';
                     l[this.character.y()][this.character.x() - 2 ] = 'B';
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() - 1, this.character.y());
                     this.map.add(box,this.character.x() - 2, this.character.y());
                     box.changeBackImage();
                     this.referee.subPoint();
                     
                     this.character.setX(-1);
                     this.map.add(this.character,this.character.x(), this.character.y());
                     
                     return;
                     
                 } 
                     Box box = (Box)this.map.getNodeFromGridPane(this.character.x() - 1, this.character.y());
                 this.map.add(box, this.character.x() - 2, this.character.y());
                 this.character.setX(-1);
                 l[this.character.y()][this.character.x()] = '.';
                 l[this.character.y()][this.character.x() - 1] = 'B';
                 
                 this.map.add(this.character, this.character.x(), this.character.y());
             }
             
            
         } else {
        if (this.map.matrix().character(this.character.y(), this.character.x() - 1) != 'X') {
        this.character.setX(-1);
        this.map.add(this.character, this.character.x(), this.character.y());
    }
    }
    }
}
    
    
 
	


