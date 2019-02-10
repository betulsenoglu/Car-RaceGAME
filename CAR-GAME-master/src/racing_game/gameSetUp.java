package racing_game;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import racing_display.Display;
import racing_manager.gameManager;

public class gameSetUp implements Runnable{
    private Thread thread;
    private Display display;
    private String title;
    private int width, height;
    private BufferStrategy buffer;
    private Graphics g;
    //private int y;
    private gameManager manager;
    public gameSetUp(String title, int width, int height){
        this.title=title;
        this.width= width;
        this.height=height;
    }
    public void init(){
    display =new Display(title, width, height);
    //y=0;
    manager=new gameManager();
    manager.init();
    }
    public synchronized void start(){
        if(thread ==null){
        thread=new Thread(this);
        thread.start();
    }
    }
    public synchronized void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        public void tick(){
           // y+=1;
           manager.tick();//gameManager/tick "y+=1";
        }
        public void render(){
            buffer = display.canvas.getBufferStrategy();
            if(buffer==null){
                display.canvas.createBufferStrategy(3);
                return ;
            }
            g= buffer.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            //drawww
            manager.render(g);
            // g.setColor(Color.RED);
            // g.fillRect(12, y, 40, 40);
            //draww bitis
            buffer.show();
            g.dispose();
            
        }
    public void run(){
            init();
            int fps=50;
            double timePerTick=1000000000/fps;
            double delta = 0;
           long current= System.nanoTime();
           
        while(true){
            delta= delta + (System.nanoTime()-current)/timePerTick;
            current= System.nanoTime();
            if(delta>=1){//delta, yani hız/sanıye işledikçe y=+1
            tick();
            render();
            delta--;
            }
        }
    }
    //deneme github23
}
