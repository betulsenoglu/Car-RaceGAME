package racing_motor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import racing_display.Display;

public class Motor implements KeyListener {
    private int x,y,ofset;
    private boolean left,right, up, down;
    public  Motor(){
        x=0;
        y=0;
       int ofset=0;
    }
    public void init(){
       // x=0; y=0;
        Display.frame.addKeyListener(this);
    }
    public void tick(){
       // x+=1;
      //  y+=1;
      ofset+=2;
      if(right)
         x+=1;
      if(left)
          x-=1;
      if(up)
          y-=1;
      if(down)
          y+=1;
    }
    public void render (Graphics g){
        
        g.setColor(Color.red);
        g.fillRect(x,y,40,60);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int source =e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT){
            right=true;
        }
        if(source == KeyEvent.VK_LEFT){
            left=true;
        }
        if(source == KeyEvent.VK_UP){
            up=true;
        }
        if(source == KeyEvent.VK_DOWN){
            down=true;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int source =e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT){
            right=false;
        }
        if(source == KeyEvent.VK_LEFT){
            left=false;
        }
        if(source == KeyEvent.VK_UP){
            up=false;
        }
        if(source == KeyEvent.VK_DOWN){
            down=false;
        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
