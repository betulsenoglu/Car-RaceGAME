package racing_manager;
import java.awt.Graphics;
import java.io.IOException;
import racing_graphics.loadImage;
import racing_motor.Motor;
import racing_world.world;
public class gameManager {
   // private int y;
    private world world;
    private Motor motor;
    
    public gameManager(){
         
      //  world.init();
      // motor= new Motor();
     // world= new world(motor);
    }
    public void init(){//initials
       //y=0;
       world=new world();
       motor=new Motor();
       
        motor.init();
        loadImage.init();
    }
    public void tick(){
       // y+=1;
       motor.tick();
    }
    public void render(Graphics g){// grafikleri tutacak
       // g.fillRect(40,y,60,60);
      // g.drawImage(loadImage.fullImage, 40,40,100,100,null);
      // g.drawImage(loadImage.subImage1,150,150,100,100,null);
     //  g.drawImage(loadImage.subImage2,300,300,100,100,null);
     world.render(g);
       motor.render(g);
    }
}
